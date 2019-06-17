package com.bkn.phone.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bkn.browser.config.App;
import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.utils.StringUtil;
import com.bkn.phone.service.WechatUserPersonService;
import com.bkn.system.dto.BaseDto;
import com.bkn.wechat.msg.WechatUserTemplateMsg;



/**
 * 移动端登陆操作
* @author 高国藩
* @date 2017年3月23日 下午2:21:02
 */
@Controller
public class WechatUserLoginController extends WechatOauthBaseController{

    private Logger logger = Logger.getLogger(WechatUserLoginController.class);
    
    @Autowired
    private WechatUserPersonService wechatUserPersonService;
    
    @Autowired WechatUserTemplateMsg wechatUserTemplateMsg;
    
    
    /**
     * 前往注册网页
    * @author 高国藩
    * @date 2019年6月17日 下午4:51:47
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/register", method = RequestMethod.GET) 
    public ModelAndView userRrgister(HttpServletRequest request, HttpServletResponse response) {
        String openId = getOpenId(request, response, App.Wechat.WECHAT_APP_ID_BKN);
        if (StringUtil.isEmpty(openId)){
            return null;
        }
        setJsapiSignData(request);
        logger.info(openId);
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/注册中心");
        return modelAndView;
    }
    
    
    
    /**
     * 注册操作
    * @author 高国藩
    * @date 2019年6月17日 下午8:03:04
    * @param request
    * @param response
    * @param phone
    * @param code
    * @return
     */
    @RequestMapping(value = RouteConfig.WechatUser.WECHAT_USER_LOGIN_VIEW, method = RequestMethod.POST)
    @ResponseBody
    public BaseDto viewUserLoginAction(HttpServletRequest request, HttpServletResponse response, String phone, String code){
        String openId = getOpenId(request, response, App.Wechat.WECHAT_APP_ID_BKN);
        if (StringUtil.isEmpty(openId)){
            return null;
        }
        return wechatUserPersonService.viewUserLoginAction(openId, getAccessToken(), phone, code, request); 
    }
    
    
    /**
     * 获取短信验证码
    * @author 高国藩
    * @date 2017年3月23日 下午3:26:28
    * @param phone          电话号码
    * @param request
    * @param response
    * @return               验证码
     */
    @RequestMapping(value = RouteConfig.WechatUser.WECHAT_USER_LOGIN_CODE, method = RequestMethod.POST)
    @ResponseBody
    public BaseDto getVerifyCodeAction(String phone, HttpServletRequest request, HttpServletResponse response){
        return wechatUserPersonService.getVerifyCodeAction(phone);
    }
    
    
    
    /**
     * 查询聊呗信息
    * @author 高国藩
    * @date 2019年6月17日 下午5:17:52
    * @param request
    * @param response
    * @param key
    * @return
     */
    @RequestMapping(value = "app/query/key", method = RequestMethod.GET) 
    public ModelAndView userQueryKey(HttpServletRequest request, HttpServletResponse response, String key) {
        return wechatUserPersonService.userQueryKey(key);
    }
}
