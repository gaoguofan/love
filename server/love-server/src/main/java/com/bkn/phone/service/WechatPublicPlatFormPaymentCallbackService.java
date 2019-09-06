package com.bkn.phone.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkn.browser.config.App;
import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.mybatis.LoveUserInfoMapper;
import com.bkn.browser.mybatis.LoveUserInfoOrderMapper;
import com.bkn.browser.mybatis.LoveVipCoumerInfoMapper;
import com.bkn.browser.utils.DateUtil;
import com.bkn.browser.utils.SignUtil;
import com.bkn.browser.utils.StringUtil;
import com.bkn.system.dto.BaseDto;
import com.bkn.system.entity.LoveUserInfo;
import com.bkn.system.entity.LoveUserInfoOrder;
import com.bkn.system.entity.LoveVipCoumerInfo;


/**
 * 微信公众平台回调处理接口
* @author 李志伟
* @date 2017年3月14日 下午1:54:38
 */
@Service
@Transactional
public class WechatPublicPlatFormPaymentCallbackService {

    /** 日志记录对象 */
    private final Logger logger = Logger.getLogger(WechatPublicPlatFormPaymentCallbackService.class);
    
    @Autowired LoveUserInfoMapper userInfoMapper;
    @Autowired LoveUserInfoOrderMapper userInfoOrderMapper;
    @Autowired LoveVipCoumerInfoMapper vipCoumerInfoMapper;
    
    
    
    /**
     * 进行支付操作，预存单生成
    * @author 李志伟
    * @date 2019年6月17日 下午4:12:06
    * @param openId
    * @param outTradeNo
    * @param type
    * @param request
    * @return
     */
    public BaseDto perparOrderInfo(String openId, String outTradeNo, Integer infoId, HttpServletRequest request) {
        LoveUserInfo userInfo = userInfoMapper.selectByWechatId(openId);
        LoveVipCoumerInfo info = vipCoumerInfoMapper.selectByPrimaryKey(infoId);
        LoveUserInfoOrder userInfoOrder = new LoveUserInfoOrder();
        userInfoOrder.setCreateTime(DateUtil.getCurDateTrimMinutes());
        userInfoOrder.setUserId(userInfo.getUserId());
        userInfoOrder.setOutTradeNo(outTradeNo);
        userInfoOrder.setPayCategory(infoId);
        userInfoOrder.setPayMoney(info.getPackAgeMoney()*100);
        userInfoOrderMapper.insertSelective(userInfoOrder);
        return payJsApi(info.getPackAgeName(), info.getPackAgeMoney()*100, openId, outTradeNo, userInfoOrder.getOrderId(), request);
    }
    
    
    /**
     * 微信网页支付统一接口
    * @author 李志伟
    * @date 2019年1月23日 上午11:27:35
    * @param goodsName
    * @param totalFee
    * @param openId
    * @param outTradeNo
    * @param callBackUrl
    * @param request
    * @return
     */
    public BaseDto payJsApi(String goodsName, Integer totalFee, String openId, String outTradeNo, Integer orderId, HttpServletRequest request) {
        String appId = App.Wechat.PAY_APP_KEY_JOBWISDOM;
        String mchId = App.Wechat.MCH_ID_JOBWISDOM;
        String mchKey = App.Wechat.MCH_PAY_KEY_JOBWISDOM;
        String deviceInfo = "WEB";
        String spbillCreateIp = StringUtil.getIpAddr(request);
        String uuid = UUID.randomUUID().toString().replace("-", "");

        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", appId);
        parameters.put("mch_id", mchId);
        parameters.put("device_info", deviceInfo);
        parameters.put("nonce_str", uuid);
        parameters.put("body", goodsName);
        parameters.put("out_trade_no", outTradeNo);
        parameters.put("total_fee", String.valueOf(totalFee));
        parameters.put("spbill_create_ip", spbillCreateIp);
        String callBackUrl = App.System.SERVER_BASE_URL + "/" + RouteConfig.AppPay.APP_PAY_JS_API_ORDER_PATH.replace("{id}", orderId.toString());
        parameters.put("notify_url", callBackUrl);
        parameters.put("trade_type", "JSAPI");
        parameters.put("openid", openId);
        String mySign = SignUtil.createSign("UTF-8", parameters, mchKey);
        parameters.put("sign", mySign);

        logger.info("sign result : " + parameters);
        String preXml = "";
        try {
            preXml = wxUnifiedorderPost(parameters);
        } 
        catch (IOException e) {
            logger.error("wx_unifiedorder_post error : ", e);
        }
        logger.info("weixin pay request result : " + preXml);

        preXml = preXml.replace("<![CDATA[", "").replace("]]>", "");
        String returnCode = preXml.substring(preXml.indexOf("<return_code>") + 13, preXml.indexOf("</return_code>"));
        String resultCode = preXml.substring(preXml.indexOf("<result_code>") + 13, preXml.indexOf("</result_code>"));

        Map<String, String> payMap = new HashMap<String, String>();
        if (preXml.contains("<result_code>") && returnCode.equals("SUCCESS") && resultCode.equals("SUCCESS")) {
            String prepayId = preXml.substring(preXml.indexOf("<prepay_id>") + 11, preXml.indexOf("</prepay_id>"));
            String xpackage = "prepay_id=" + prepayId;
            String ts = Long.toString(System.currentTimeMillis());

            SortedMap<Object, Object> parameters2 = new TreeMap<Object, Object>();
            parameters2.put("appId", appId);
            parameters2.put("timeStamp", ts);
            parameters2.put("nonceStr", uuid);
            parameters2.put("signType", App.Wechat.SIGN_TYPE);
            parameters2.put("package", xpackage);
            String paySign = SignUtil.createSign("UTF-8", parameters2, mchKey); // SignUtil.paySign(singMap2, mchKey);

            payMap.put("resultCode", "0");
            payMap.put("appId", appId);
            payMap.put("timeStamp", ts);
            payMap.put("nonceStr", uuid);
            payMap.put("signType", App.Wechat.SIGN_TYPE);
            payMap.put("paySign", paySign);
            payMap.put("package", xpackage);
            payMap.put("transactionId", outTradeNo);
        } 
        else {
            return new BaseDto(App.System.API_RESULT_CODE_FOR_FAIL, App.System.API_RESULT_MSG_FOR_FAIL);
        }

        return new BaseDto(App.System.API_RESULT_CODE_FOR_SUCCEES, payMap);
        
    }
    
    
    
    /**
     *  微信统一下单api，获取预付单信息
    * @author 李志伟
    * @date Sep 23, 2015 7:31:07 PM
    * @param xo                         订单信息
    * @return                           预付单信息
    * @throws ClientProtocolException   客户端协议异常
    * @throws IOException               返回结果读取异常
     */
    private static String wxUnifiedorderPost(SortedMap<Object, Object> xo)
            throws ClientProtocolException, IOException {
        StringBuffer xml = new StringBuffer();
        xml.append("<xml>").append("<appid>").append(xo.get("appid"))
                .append("</appid>").append("<body><![CDATA[")
                .append(xo.get("body")).append("]]></body>")
                .append("<device_info>").append(xo.get("device_info"))
                .append("</device_info>").append("<mch_id>")
                .append(xo.get("mch_id")).append("</mch_id>")
                .append("<nonce_str>").append(xo.get("nonce_str"))
                .append("</nonce_str>").append("<notify_url>")
                .append(xo.get("notify_url")).append("</notify_url>")
                .append("<out_trade_no>").append(xo.get("out_trade_no"))
                .append("</out_trade_no>").append("<spbill_create_ip>")
                .append(xo.get("spbill_create_ip"))
                .append("</spbill_create_ip>").append("<total_fee>")
                .append(xo.get("total_fee")).append("</total_fee>")
                .append("<trade_type>").append(xo.get("trade_type"))
                .append("</trade_type>").append("<openid>")
                .append(xo.get("openid")).append("</openid>")
                .append("<sign><![CDATA[").append(xo.get("sign"))
                .append("]]></sign>").append("</xml>");

        StringBuffer resultXml = new StringBuffer();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
            StringEntity myEntity = new StringEntity(xml.toString(), "utf-8");
            httpPost.addHeader("Content-Type", "text/xml");
            httpPost.setEntity(myEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    InputStream is = resEntity.getContent();
                    BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String line = "";
                    while ((line = in.readLine()) != null) {
                        resultXml.append(line);
                    }
                }
            } 
            finally {
                response.close();
            }
        } 
        finally {
            httpclient.close();
        }
        return resultXml.toString();
    }

    
    /**
     * 支付成功回调
    * @author 李志伟
    * @date 2019年6月17日 下午4:24:02
    * @param id
     */
    public void appWechatUserPayForOrderBackPath(Integer id) {
        LoveUserInfoOrder userInfoOrder = userInfoOrderMapper.selectByPrimaryKey(id);
        userInfoOrder.setFinishTime(DateUtil.getCurDateTrimMinutes());
        userInfoOrderMapper.updateByPrimaryKeySelective(userInfoOrder);
        
        LoveUserInfo userBasicInfo = userInfoMapper.selectByPrimaryKey(userInfoOrder.getUserId());
        userBasicInfo.setIsVip(true);
        String vipEx;
        switch (userInfoOrder.getPayCategory()) {
        case 1:
            vipEx = StringUtil.isEmpty(userBasicInfo.getVipExprise()) ? DateUtil.subYear(DateUtil.getCurDateTrimMinutes()) : DateUtil.subYear(userBasicInfo.getVipExprise());
            userBasicInfo.setVipExprise(vipEx);
            break;
        case 2:
            vipEx = StringUtil.isEmpty(userBasicInfo.getVipExprise()) ? DateUtil.subJd(DateUtil.getCurDateTrimMinutes()) : DateUtil.subJd(userBasicInfo.getVipExprise());
            userBasicInfo.setVipExprise(vipEx);
            break;
        case 3:
            vipEx = StringUtil.isEmpty(userBasicInfo.getVipExprise()) ? DateUtil.subMonth(DateUtil.getCurDateTrimMinutes()) : DateUtil.subMonth(userBasicInfo.getVipExprise());
            userBasicInfo.setVipExprise(vipEx);
            break;
        default:
            break;
        }
        userInfoMapper.updateByPrimaryKeySelective(userBasicInfo);
    }
}
