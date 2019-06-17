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
    
    
    /**
     * 升级会员
    * @author 高国藩
    * @date 2019年6月17日 下午6:07:32
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/mvp", method = RequestMethod.GET) 
    public ModelAndView appMvp(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appMvp();
    }
    
    
    /**
     * 我的订单
    * @author 高国藩
    * @date 2019年6月17日 下午6:12:06
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/order", method = RequestMethod.GET) 
    public ModelAndView appOrder(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appOrder();
    }
    
    
    /**
     * 单条明细
    * @author 高国藩
    * @date 2019年6月17日 下午7:47:36
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/desc", method = RequestMethod.GET) 
    public ModelAndView appDesc(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appDesc();
    }
    
    
    /**
     * 话术加锁
    * @author 高国藩
    * @date 2019年6月17日 下午7:48:23
    * @param request
    * @param response
    * @return
     */
    @RequestMapping(value = "app/lock", method = RequestMethod.GET) 
    public ModelAndView appLock(HttpServletRequest request, HttpServletResponse response) {
        return wechatMenuInfoService.appLock();
    }
    
}
