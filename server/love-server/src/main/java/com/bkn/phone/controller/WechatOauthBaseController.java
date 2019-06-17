package com.bkn.phone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bkn.browser.config.App;
import com.bkn.browser.utils.HttpClientUtil;
import com.bkn.browser.utils.SignUtil;
import com.bkn.browser.utils.StringUtil;
import com.bkn.system.service.RedisService;

import net.sf.json.JSONObject;

/**
 * 授权分类,授权回调,accesstonen,openId,web环境临时票据 等....
* @author 高国藩
* @date 2017年3月14日 下午2:26:31
 */
public class WechatOauthBaseController {

    private Logger logger = Logger.getLogger(WechatOauthBaseController.class);
    
    @Autowired
    private RedisService redisService;
    
    /**
     * 微信开放授权平台授权
    * @author 高国藩
    * @date 2017年2月28日 下午4:36:19
    * @param request        request
    * @param response       response
    * @param appId          appId(授权ID)
    * @return               String
     */
    public String getOpenId(HttpServletRequest request, HttpServletResponse response, String appId) {
        try {
            String openId = request.getSession().getAttribute(App.Session.WECHAT_OPEN_ID).toString();
            return openId;
        } catch (Exception e) {
            sendRedirect(App.Session.WECHAT_OPEN_ID, appId, request, response);
        }
        return null;
    }
    
    /**
     * 获取微信accessToken接口的临时票据
    * @author 高国藩
    * @date 2016年5月25日 上午10:19:45
    * @param request request
    * @return        accessToken
     */
    public String getAccessToken() {
        String accessToken = redisService.get(App.Redis.STORE_WECHAT_ACCESS_TOKEN_KEY_HASH);
        if (StringUtil.isEmpty(accessToken)){
            String appId = App.Wechat.WECHAT_APP_ID_BKN;
            String appSecret = App.Wechat.WECHAT_APP_SECRET_BKN;
            String getAccessTokenUrl = String.format(App.Wechat.GET_ACCESS_TOKEN_URL, new Object[] {appId, appSecret});
            String accessTokenRes = HttpClientUtil.sendGetReq(getAccessTokenUrl, "utf-8");
            JSONObject accessTokenJSON = JSONObject.fromObject(accessTokenRes);
            accessToken = accessTokenJSON.getString("access_token");
            redisService.set(App.Redis.STORE_WECHAT_ACCESS_TOKEN_KEY_HASH, accessToken);
            redisService.expire(App.Redis.STORE_WECHAT_ACCESS_TOKEN_KEY_HASH, 60*30);
            logger.info("accessToken is update success ... the value is " + accessToken);
            return accessToken;
        } else {
            return accessToken;
        }
    }
    
    
    /**
     * 获取微信JS接口的临时票据
    * @author 
    * @date Aug 17, 2015 4:39:06 PM
    * @return           当前门店的微信JS接口的临时票据
     */
    public String getJsapiTicketByStore() {
        String jsapiTicket = redisService.get(App.Redis.STORE_WECHAT_JSAPI_TICKET_KEY_HASH);
        if (StringUtil.isEmpty(jsapiTicket)){
            String getJsapiTicketUrl = String.format(App.Wechat.GET_JSAPI_TICKET_URL, new Object[] {getAccessToken()});
            String jsapiTicketRes = HttpClientUtil.sendGetReq(getJsapiTicketUrl, "utf-8");
            JSONObject jsapiTicketJSON = JSONObject.fromObject(jsapiTicketRes);
            jsapiTicket = jsapiTicketJSON.getString("ticket");
            redisService.set(App.Redis.STORE_WECHAT_JSAPI_TICKET_KEY_HASH, jsapiTicket);
            redisService.expire(App.Redis.STORE_WECHAT_JSAPI_TICKET_KEY_HASH, 60*30);
            logger.info("jsapiTicket is update success ... the value is " + jsapiTicket);
            return jsapiTicket;
        } else {
            return jsapiTicket;
        }
    }
    
    /**
     * 为当前地址进行微信js api授权
    * @author 
    * @date Aug 17, 2015 4:44:46 PM
    * @param request    请求对象
     */
    public void setJsapiSignData(HttpServletRequest request) {
        String url = getRequstUri(request);
        String appId = App.Wechat.WECHAT_APP_ID_BKN;
        String jsapiTicket = getJsapiTicketByStore();
        Map<String, String> sign = SignUtil.jsSign(jsapiTicket, url, appId);
        logger.info("setJsapiSignData --> url : " + url + ", sign : " + sign);
        for (String key : sign.keySet()) {
            request.setAttribute(key, sign.get(key));
        }
    }
    
    /**
     * 微信授权平台,发起公众授权,模式为默认基础模式
    * @author 高国藩
    * @date Aug 17, 2015 4:35:42 PM
    * @param openidKey      存储openid的session key
    * @param appId          appId    
    * @param request        请求对象
    * @param response       返回对象
    * @throws IOException   重定向失败时抛出的异常
     */
    public void sendRedirect(String openidKey, String appId, HttpServletRequest request, HttpServletResponse response) {
        String redirectUrl = getRequstUri(request);
        redirectUrl = redirectUrl.replace("&", "__");
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
            String authUrl = App.Wechat.AUTH_REDIRECT_COMMON_URL.replace("{app_id}", appId)
                    .replace("{redirect_uri}", redirectUrl)
                    .replace("{openid_key}", openidKey);
            if (isAjax(request)) {
                response.setStatus(App.System.ERROR_CODE_FORBIDDEN);
                PrintWriter pw = response.getWriter();
                pw.write(authUrl);
                pw.flush();
                pw.close();
            } 
            else {
                response.sendRedirect(authUrl);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取请求地址的绝对路径
    * @author 高国藩
    * @date 2017年3月14日 下午2:00:33
    * @param request
    * @return
     */
    private String getRequstUri(HttpServletRequest request) {
        String url = App.System.SERVER_BASE_URL + request.getRequestURI().replace(request.getContextPath(), "");
        String params = request.getQueryString();
        if (!StringUtils.isEmpty(params)) {
            url += "?" + params;
        }
        return url;
    }
    
    /**
     * 判断是否是ajax请求
    * @author 高国藩
    * @date 2017年3月14日 下午2:01:27
    * @param request
    * @return
     */
    public boolean isAjax(HttpServletRequest request) {
        String ajaxHeader = request.getHeader("isAjax");
        return ajaxHeader != null && "1".equals(ajaxHeader);
    }
}
