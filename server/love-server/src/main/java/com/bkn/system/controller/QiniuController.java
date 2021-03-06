package com.bkn.system.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bkn.browser.config.RouteConfig;
import com.bkn.phone.controller.WechatOauthBaseController;
import com.bkn.system.dto.BaseDto;
import com.bkn.system.service.QiniuService;

import net.sf.json.JSONObject;

/**
 * 七牛云存储相关api
 * @author 张进军
 * @date Jul 10, 2015 8:44:50 PM 
 */
@Controller
public class QiniuController extends WechatOauthBaseController {
    
    /** 七牛云存储api操作服务类 */
    @Autowired
    private QiniuService qiniuService;
    
    /**
     * 获取七牛上传默认策略的token
    * @author 张进军
    * @date Nov 23, 2015 11:50:32 AM
    * @return   上传token
     */
    @RequestMapping(value = RouteConfig.Qiniu.UPTOKEN)
    @ResponseBody
    public Map<String, String> qiniuUptoken() {
        return qiniuService.qiniuUptoken();
    }
    
    /**
     * 抓取网络资源上传到七牛
    * @author 张进军
    * @date Aug 22, 2015 11:36:03 AM
    * @param fromUrl       资源文件地址
    * @param key           七牛目标地址
    * @return              成功返回码0,失败返回其他错误码
     */
    @RequestMapping(value = RouteConfig.Qiniu.FETCH, method = RequestMethod.POST)
    @ResponseBody
    public BaseDto fetch(String fromUrl, String key) {
        return qiniuService.fetch(fromUrl, key);
    }
    
    /**
     * 文字转语音
    * @author 张进军
    * @date Nov 23, 2015 10:59:06 AM
    * @param text   需要转换的文字
    * @param per    发音人，1:男性，0:女性
    * @return   语音地址
     */
    @RequestMapping(value = RouteConfig.Qiniu.TEXT_TO_VOICE)
    @ResponseBody
    public BaseDto textToVoice(String text, int per) {
        return qiniuService.textToVioce(text, per);
    }
    
    /**
     * 将base64上传至七牛图片库
    * @author 李志伟
    * @date 2015年11月9日 下午8:13:37
    * @param qiniu 七牛上传参数
    * @return 七牛地址
     * @throws IOException 
     */
    @RequestMapping(value = RouteConfig.Qiniu.BASE64, method = RequestMethod.POST)
    @ResponseBody
    public BaseDto base64(@RequestBody JSONObject qiniu) throws IOException {
        return qiniuService.put64(qiniu.get("stringBase64").toString(), qiniu.get("key").toString());
    } 
    
    /**
     * 上传微信media到七牛
    * @author 李志伟
    * @date Aug 22, 2015 11:53:15 AM
    * @param mediaid    微信的资源id
    * @param key        七牛目标地址
    * @param request    请求对象
    * @return           成功返回码0,失败返回其他错误码
     */
    @RequestMapping(value = RouteConfig.Wechat.FETCH_MEDIA, method = RequestMethod.POST)
    @ResponseBody
    public BaseDto uploadMediaToQiniu(String mediaid, String key, HttpServletRequest request){
        String accessToken = getAccessToken();
        return qiniuService.uploadMediaToQiniu(mediaid, key, accessToken);
    }
}
