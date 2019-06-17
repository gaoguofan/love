package com.bkn.phone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.utils.StringUtil;
import com.bkn.phone.service.WechatPublicPlatFormPaymentCallbackService;
import com.bkn.system.dto.BaseDto;

import net.sf.json.JSONObject;

/**
 * 微信支付,请求
* @author 高国藩
* @date 2017年3月14日 下午12:05:35
 */
@Controller
public class WechatPaymentController {

    @Autowired
    private WechatPublicPlatFormPaymentCallbackService wechatPublicPlatFormPaymentCallbackService;
    
    
    
    /**
     * 微信网页支付
    * @author 高国藩
    * @date 2019年1月23日 下午12:14:38
    * @param request
    * @param response
    * @param requestBody
    * @return
     */
    @RequestMapping(value = "app/pay/js/api", method=RequestMethod.POST)
    @ResponseBody
    public BaseDto getNativeCode(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject requestBody) {
        String outTradeNo = StringUtil.getKey(); 
        return wechatPublicPlatFormPaymentCallbackService.perparOrderInfo(requestBody.getString("openId"), outTradeNo, 
                Integer.valueOf(requestBody.getString("info")), request);
    }
    
    
    
    /**
     * 微信支付网页支付-组合订单支付回调
    * @author 高国藩
    * @date 2019年1月24日 下午5:21:41
    * @param request
    * @param response
    * @param orderId
    * @return
     */
    @RequestMapping(value = RouteConfig.AppPay.APP_PAY_JS_API_ORDER_PATH)
    @ResponseBody
    public String appWechatUserPayForOrderBackPath(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id){
        wechatPublicPlatFormPaymentCallbackService.appWechatUserPayForOrderBackPath(id);
        return "SUCCESS";
    }
    
}
