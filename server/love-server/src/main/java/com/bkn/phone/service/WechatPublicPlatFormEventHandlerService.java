package com.bkn.phone.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkn.browser.config.App;
import com.bkn.browser.utils.HttpClientUtil;
import com.bkn.browser.utils.MessageUtil;
import com.bkn.system.dto.NewsMessageDto;
import com.bkn.system.dto.TextMessageDto;

import net.sf.json.JSONObject;

/**
 * 公众平台推送事件处理
* @author 高国藩
* @date 2015年8月11日 上午11:47:56
 */
@Service
@Transactional
public class WechatPublicPlatFormEventHandlerService {
	
	/** 日志*/
	private Logger logger = Logger.getLogger(WechatPublicPlatFormEventHandlerService.class);
	
	
	/**
	 * 微信后台服务监控
	* @author 高国藩
	* @date 2016年10月18日 下午4:05:23
	* @param request      request
	* @return             提醒内容
	* @throws Exception   ex
	 */
	public String doChat(HttpServletRequest request) throws Exception {
	    String responseStr = "";
	    Map<String, String> requestMap = MessageUtil.parseXml(request);
	    logger.info(System.getProperty("line.separator", "\n") + " request xml ===>  " + JSONObject.fromObject(requestMap));
	    String openId = requestMap.get(MessageUtil.FROM_USER_NAME);
        String toUserName = requestMap.get(MessageUtil.TO_USER_NAME);
        String msgType = requestMap.get(MessageUtil.MSG_TYPE);
        String createTime = requestMap.get("CreateTime");
        if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
            String event = requestMap.get(MessageUtil.EVENT);
            switch (event){
                case MessageUtil.EVENT_TYPE_SUBSCRIBE :            // 关注事件
                    responseStr = wxSubUserInfoAction(openId, toUserName, requestMap, createTime);
                    break;
                case MessageUtil.EVENT_SCAN :                      // 二维码扫描事件()
                    responseStr = wxScanUserInfoAction(openId, toUserName, requestMap, createTime);
                    break;
                case MessageUtil.EVENT_TYPE_UNSUBSCRIBE :          // 取消关注事件
                    responseStr = wxUnSubUserInfoAction(openId, toUserName, requestMap, createTime);
                    break;
                case MessageUtil.EVENT_ITEMS_STATUS :              // 图文发送数据推送事件
                    break;
                default :
            }
        }
        else if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){
            String notice = MessageUtil.autoMessageMap.get(requestMap.get(MessageUtil.CONTENT));
            if (!StringUtils.isEmpty(notice)){
                responseStr = replyTextMessage(notice, openId, toUserName, createTime);
            }
            else {
                responseStr = replyTextMessage(MessageUtil.NOTICTY_TEXT, openId, toUserName, createTime);
            }
        }
        logger.info(System.getProperty("line.separator", "\n") + " response xml ===> " + responseStr);
	    return responseStr;
	}
	
	/**
     *  微信授权回调处理
    * @author 高国藩
    * @date Aug 17, 2015 3:54:23 PM
    * @param redirect       重定向地址
    * @param code           微信返回，用于获取授权的access token
    * @param state          随机字符，用作校验
    * @param scope          应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
    *                       snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。
    *                           并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
    * @param openidKey      存储openid的session key                          
    * @param appId          微信公众号id
    * @param appSecret      微信公众号密钥
    * @param request        请求对象
    * @param response       返回对象
     * @throws IOException  重定向失败时抛出的异常 
     * @throws ServletException 
     */
    public void wsCallBackRequestMapForBils(String redirect, String code,
            String state, String scope, String openidKey, String appId,
            String appSecret, HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        redirect = redirect.replace("__", "&");

        if (StringUtils.isEmpty(code)) {
            response.sendRedirect(redirect);
        }

        String accessTokenRes = HttpClientUtil.sendGetReq(String.format(App.Wechat.AUTH_ACCESS_TOKEN_URL, new Object[] { appId, appSecret, code }), "utf-8");
        JSONObject accessTokenJson = JSONObject.fromObject(accessTokenRes);

        // 如果授权失败，跳转到重定向页面
        if (accessTokenJson.containsKey("errcode")) {
            String errcode = accessTokenJson.get("errcode").toString();
            String errmsg = accessTokenJson.get("errmsg").toString();
            logger.error("use weixin login err, code " + code + ", errcode " + errcode + ", errmsg " + errmsg);
            response.sendRedirect(redirect);
            return;
        }

        String openId = accessTokenJson.getString("openid");
        System.out.println("授权成功,openId为：" + openId);
        request.getSession().setAttribute(openidKey, openId);
        response.sendRedirect(redirect);
        
    }
	
	/**
	 * 处理关注事件
	* @author 高国藩
	* @date 2016年10月18日 下午4:23:27
	* @param openId        用户ID
	* @param storeWechatId 公众号原始ID
	* @param requestMap    requestMap
	* @return              结束语
	 */
	public String wxSubUserInfoAction(String openId, String storeWechatId, Map<String, String> requestMap, String createTime){
	    String result = replyTextMessage(MessageUtil.FIRST_SUB_TEXT, openId, storeWechatId, createTime);
	    return result;
	}
	
	/**
	 * 用户扫描票据二维码进入公众号
	* @author 高国藩
	* @date 2016年10月18日 下午5:58:38
	* @param openId              openId
	* @param storeWechatId       storeWechatId
	* @param requestMap          requestMap
	* @return                    String
	 */
	public String wxScanUserInfoAction(String openId, String storeWechatId, Map<String, String> requestMap, String createTime){
	    String result = "";
	    return result;
	}
	
	/**
     * 用户取消关注
    * @author 高国藩
    * @date 2016年10月18日 下午5:58:38
    * @param openId              openId
    * @param storeWechatId       storeWechatId
    * @param requestMap          requestMap
    * @return                    String
     */
	public String wxUnSubUserInfoAction(String openId, String storeWechatId, Map<String, String> requestMap, String createTime){
        return "";
    }
	
	
	
	/**
	 * 获得文本自动回复的信息
	* @author 高国藩
	* @date 2015年8月11日 上午11:42:57
	* @param context 文本内容
	* @param fromUserName 发送者
	* @param toUserName 接受者
	* @return 返回String
	 */
	public String replyTextMessage(String context, String fromUserName, String toUserName, String createTime){
		/**回复文本消息*/
		TextMessageDto textMessage = new TextMessageDto();
		textMessage.setContent(context);
		textMessage.setFromUserName(toUserName);
		textMessage.setToUserName(fromUserName);
		textMessage.setCreateTime(Long.valueOf(createTime));
		textMessage.setMsgType("text");
		return MessageUtil.textMessageToXml(textMessage);
	}
	
	/**
	 * 回复图文消息,活动
	* @author 高国藩
	* @date 2015年8月11日 上午11:47:10
	* @param fromUserName 发送者
	* @param storeWechatId 接受者
	* @return 返回String
	 */
	public String replyNewsMessage(String fromUserName, String storeWechatId){
		NewsMessageDto newsMessage = new NewsMessageDto();
		return MessageUtil.newsMessageToXml(newsMessage);
	}
}
