package com.bkn.system.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.bkn.browser.config.App;
import com.bkn.browser.utils.DateUtil;

/**
 * 短信服务类
* @author 高国藩
* @date Feb 26, 2016 8:48:40 PM
 */
@Service
public class SmsService {
    
    @Autowired
    private RedisService redisService;
    
    public static void main(String[] args) {
        new SmsService().sendCheckMsgAlibaMessage("18734911338", "1234");
    }
    
    /**
     * 获取短信验证码
    * @author 高国藩
    * @date 2019年1月11日 下午4:48:25
    * @param phoneNum
    * @param code
    * @return
     */
    public boolean sendCheckMsgAlibaMessage(String phoneNum, String code) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIBBaXMeNUxnGr", "rEtBeyV38AFyLy3auwB1RdqNkOvCTX");
        try {
            System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
            System.setProperty("sun.net.client.defaultReadTimeout", "10000");
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(phoneNum);
            request.setSignName("众粤贸易");
            request.setTemplateCode("SMS_153655265");
            JSONObject param = new JSONObject();
            param.put("code", code);
            request.setTemplateParam(param.toString());
            request.setOutId("yourOutId");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                redisService.setex(App.Redis.PHONE_VERIFY_CODE_KEY_PRE + phoneNum, code, 180);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
