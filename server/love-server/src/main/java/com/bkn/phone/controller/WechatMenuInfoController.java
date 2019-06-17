package com.bkn.phone.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bkn.phone.service.WechatMenuInfoService;


/**
 * 菜单导航信息
* @author 高国藩
* @date 2019年6月17日 下午5:38:02
 */
@Controller
public class WechatMenuInfoController extends WechatOauthBaseController{

    @Autowired WechatMenuInfoService wechatMenuInfoService;
    
    /**
     * 前往首页
    * @author 高国藩
    * @date 2019年6月17日 下午5:38:45
    * @param request
    * @param response
    * @param key
    * @return
     */
    @RequestMapping(value = "app/index", method = RequestMethod.GET) 
    public ModelAndView appIndex(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appIndex();
    }
    
    
    /**
     * 前往聊天实战
    * @author 高国藩
    * @date 2019年6月17日 下午5:47:55
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/article", method = RequestMethod.GET) 
    public ModelAndView appArticle(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appArticle();
    }
    
    
    /**
     * 前往课程中心
    * @author 高国藩
    * @date 2019年6月17日 下午5:53:06
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/class", method = RequestMethod.GET) 
    public ModelAndView appClass(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appClass();
    }
    
    
    /**
     * 前往会员中心
    * @author 高国藩
    * @date 2019年6月17日 下午5:53:28
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/user", method = RequestMethod.GET) 
    public ModelAndView appUser(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appUser();
    }
    
}
