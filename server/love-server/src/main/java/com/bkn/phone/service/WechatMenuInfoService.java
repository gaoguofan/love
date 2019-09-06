package com.bkn.phone.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.bkn.browser.mybatis.LoveArticleInfoMapper;
import com.bkn.browser.mybatis.LoveCategoryInfoMapper;
import com.bkn.browser.mybatis.LoveClassInfoMapper;
import com.bkn.browser.mybatis.LoveUserInfoMapper;
import com.bkn.system.entity.LoveArticleInfo;
import com.bkn.system.entity.LoveCategoryInfo;
import com.bkn.system.entity.LoveClassInfo;
import com.bkn.system.entity.LoveUserInfo;



/**
 * 
* @author 李志伟
* @date 2019年6月17日 下午5:39:52
 */
@Service
@Transactional
public class WechatMenuInfoService {
    
    @Autowired LoveCategoryInfoMapper loveCategoryInfoMapper;
    @Autowired LoveArticleInfoMapper loveArticleInfoMapper;
    @Autowired LoveClassInfoMapper loveClassInfoMapper;
    @Autowired LoveUserInfoMapper loveUserInfoMapper;
    
    
    public ModelAndView appIndex() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/话术首页");
        List<LoveCategoryInfo> loveCategoryInfos = loveCategoryInfoMapper.selectAll();
        modelAndView.addObject("loveCategoryInfos", loveCategoryInfos);
        return modelAndView;
    }

    public ModelAndView appArticle() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/文章列表");
        List<LoveArticleInfo> loveArticleInfos = loveArticleInfoMapper.selectAll();
        modelAndView.addObject("loveArticleInfos", loveArticleInfos);
        return modelAndView;
    }
    
    
    /**
     * 文章详情信息
    * @author 李志伟
    * @date 2019年6月24日 下午3:31:43
    * @param id
    * @return
     */
    public ModelAndView appArticleInfo(Integer id) {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/文章详情");
        LoveArticleInfo loveArticleInfos =  loveArticleInfoMapper.selectByPrimaryKey(id);
        modelAndView.addObject("loveArticleInfos", loveArticleInfos);
        return modelAndView;
    }
    

    public ModelAndView appClass() {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/课程中心");
        List<LoveClassInfo> loveArticleInfos = loveClassInfoMapper.selectAll();
        modelAndView.addObject("loveArticleInfos", loveArticleInfos);
        return modelAndView;
    }
    
    
    /**
     * 课程详情信息
    * @author 李志伟
    * @date 2019年6月24日 下午4:15:46
    * @param id
    * @return
     */
    public ModelAndView appClassInfo(Integer id) {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/课程详情");
        LoveClassInfo loveArticleInfos = loveClassInfoMapper.selectByPrimaryKey(id);
        modelAndView.addObject("loveArticleInfos", loveArticleInfos);
        return modelAndView;
    }
    

    public ModelAndView appUser(String openId) {
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/会员中心");
        LoveUserInfo selectByWechatId = loveUserInfoMapper.selectByWechatId(openId);
        if (selectByWechatId == null)
            return new ModelAndView("redirect:app/register");
        modelAndView.addObject("userInfo", selectByWechatId);
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
        ModelAndView modelAndView = new ModelAndView("uclubdoctor/预支付");
        modelAndView.addObject("openId", openId);
        modelAndView.addObject("info", infoId);
        return modelAndView;
    }

}
