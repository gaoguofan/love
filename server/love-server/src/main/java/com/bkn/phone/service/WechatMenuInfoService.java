package com.bkn.phone.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
* @author 高国藩
* @date 2019年6月17日 下午5:39:52
 */
@Service
@Transactional
public class WechatMenuInfoService {
    
    public ModelAndView appIndex() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/话术首页");
        return modelAndView;
    }

    public ModelAndView appArticle() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/文章列表");
        return modelAndView;
    }

    public ModelAndView appClass() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/课程中心");
        return modelAndView;
    }

    public ModelAndView appUser() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/会员中心");
        return modelAndView;
    }

    public ModelAndView appMvp() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/升级会员");
        return modelAndView;
    }

    public ModelAndView appOrder() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/我的订单");
        return modelAndView;
    }

    public ModelAndView appDesc() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/单条明细");
        return modelAndView;
    }

    public ModelAndView appLock() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/话术加锁");
        return modelAndView;
    }

    public ModelAndView appPay(String openId, Integer infoId) {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/pay");
        modelAndView.addObject("openId", openId);
        modelAndView.addObject("info", infoId);
        return modelAndView;
    }

}