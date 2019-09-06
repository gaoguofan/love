package com.bkn.phone.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bkn.browser.config.App;
import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.utils.SignUtil;
import com.bkn.phone.service.WechatPublicPlatFormEventHandlerService;

/**
 * 公众平台对接接口
* @author 李志伟
* @date 2017年3月14日 上午10:20:39
 */
@Controller
public class WechatOauthMessageController extends WechatOauthBaseController {
    
    @Autowired
    private WechatPublicPlatFormEventHandlerService wechatPublicPlatFormEventHandlerService;

    /**
     * 微信公众平台开发者模式启用
    * @author 李志伟
    * @date 2015年8月11日 上午10:55:31
    * @param request        请求信息封装
    * @param response       返回信息
    * @throws ServletException 请求异常
    * @throws IOException 读写异常
     */
    @RequestMapping(value = RouteConfig.Wechat.CHART, method = RequestMethod.GET)
    public void dochart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    /**
     * 公众平台返回用户请求
    * @author 李志伟
    * @date 2017年3月14日 上午11:05:51
    * @param request        request
    * @param response       response
    * @throws Exception     Exception
     */
    @RequestMapping(value = RouteConfig.Wechat.CHART, method = RequestMethod.POST)
    public void chart(HttpServletRequest request, HttpServletResponse response)throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String respMessage = wechatPublicPlatFormEventHandlerService.doChat(request);
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }
    
    
    /**
     *  微信公众开放平台回调
    * @author 李志伟
    * @date Aug 17, 2015 3:54:23 PM
    * @param redirect       重定向地址
    * @param code           微信返回，用于获取授权的access token
    * @param state          随机字符，用作校验
    * @param scope          应用授权作用域
    * @param openidKey      存储openid的session key                          
    * @param request        请求对象
    * @param response       返回对象
     * @throws IOException  重定向失败时抛出的异常 
     * @throws ServletException 
     */
    @RequestMapping(value = RouteConfig.Wechat.CALL_BACK_OPEN_SDK)
    public void wsCallBackRequestMapForBils(String redirect, String code, String state, String scope, @PathVariable String openidKey,
            HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String appId = App.Wechat.WECHAT_APP_ID_BKN;
        String appSecret = App.Wechat.WECHAT_APP_SECRET_BKN;
        wechatPublicPlatFormEventHandlerService.wsCallBackRequestMapForBils(redirect, code, state, scope, openidKey, appId, appSecret, request, response);
    }
    
}
