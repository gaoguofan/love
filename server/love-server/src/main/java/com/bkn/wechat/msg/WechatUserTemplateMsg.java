package com.bkn.wechat.msg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bkn.browser.config.App;
import com.bkn.browser.config.RouteConfig;
import com.bkn.browser.utils.DateUtil;
import com.bkn.browser.utils.HttpClientUtil;
import com.bkn.phone.controller.WechatOauthBaseController;

import net.sf.json.JSONObject;

/**
 * 微信消息，模板信息推送
* @author 李志伟
* @date 2018年12月4日 上午11:27:11
 */
@Component
public class WechatUserTemplateMsg extends WechatOauthBaseController {

    /** 订单实时进度推送模板 */
    public static final String orderStatusMsg = "4fOZa9X5UWg-wff6isbKymhD5yI1Chy60TXWaSIkxZc";
    /** 检测报告完成模板通知 */
    public static final String testDateFinishMsg = "sw-x2xrVA750BIdVbjH3ViZhm7pPiSfq65XEAGdf0B4";
    /** 检测报告收到模板通知 */
    public static final String testDateRecvieMsg = "Vvh6cRyzEYdTeXurpsADgnhNMnNObA4BE29JvwtWjEc";
    /** 检测费用提醒模板通知 */
    public static final String testDateMoneyMsg = "XWRIjsLlmYsAdvUCutUnwbPEOmhWaN7xIT3RgAzm7wM";
    /** 支付结果通知 */
    public static final String testDateMoneyPaySuccessMsg = "Myb--kl3NgbShH6Li-BLIJyCTxCATFXUgIIEc2mK8KM";
    /** 订单录入，请求支付通知 */
    public static final String orderNeedPayMsg = "wlnaAdV1MTRxAjMrpvBTdmj6MhBuk2D0_Z7GApac0F8";
    
    /** 接口地址 */
    public static final String wechatMsgPostPath = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    
    /**
     * 测评费用提醒模板通知
    * @author 李志伟
    * @date 2018年12月4日 上午11:50:54
    * @param openId             微信用户标示
    * @param accessToken        公众平台授权码
    * @param projectName        测评项目名称
    * @param money              费用
    * @param userName           测评员
    * @param id                 订单索引
    * @return                   发送状态
     */
    public boolean msgTestDateMoneyMsg(String openId, String projectName, String money, String userName, Integer id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", testDateMoneyMsg);
        requestBody.put("url", App.System.SERVER_BASE_URL + "/" + RouteConfig.WechatUser.WECHAT_APP_PAY_FOR_TEST + "?orderId=" + id);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", projectName + "测评费用单据");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", projectName);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", money);
        requestData.put("keyword2", k2);
        Map<String, String> k3 = new HashMap<>();
        k3.put("value", money);
        requestData.put("keyword3", k3);
        Map<String, String> k4 = new HashMap<>();
        k4.put("value", DateUtil.getCurDateChine());
        requestData.put("keyword4", k4);
        Map<String, String> k5 = new HashMap<>();
        k5.put("value", userName);
        requestData.put("keyword5", k5);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "点击【详情】，完成付款后开始测评");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    /**
     * 测评订单支付完成通知
    * @author 李志伟
    * @date 2018年12月4日 下午12:21:29
    * @param openId         微信用户授权码
    * @param orderNo        订单标号
    * @param money          费用
    * @param userName       客户名称
    * @return               发送状态
     */
    public boolean msgTestDateMoneyPaySuccessMsg(String openId, String orderNo, String money, String userName) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", testDateMoneyPaySuccessMsg);
        requestBody.put("url", null);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "订单支付状态更新通知");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", userName);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", orderNo);
        requestData.put("keyword2", k2);
        Map<String, String> k3 = new HashMap<>();
        k3.put("value", orderNo);
        requestData.put("keyword3", k3);
        Map<String, String> k4 = new HashMap<>();
        k4.put("value", money + "元");
        requestData.put("keyword4", k4);
        Map<String, String> k5 = new HashMap<>();
        k5.put("value", DateUtil.getCurDateTrimMinutes());
        requestData.put("keyword5", k5);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "订单支付完成，请进行测评");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    /**
     * 系统录入测评数据完成
    * @author 李志伟
    * @date 2018年12月4日 下午12:27:43
    * @param openId         微信授权码
    * @param orderNo        测评订单标示
    * @return               
     */
    public boolean msgTestDateReceiveMsg(String openId, String orderNo) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", testDateRecvieMsg);
        requestBody.put("url", null);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "您的测评报告已生成，正在人工处理");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", DateUtil.getCurDateChine());
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", orderNo);
        requestData.put("keyword2", k2);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "诊断报告将于5个工作日内发送");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    /**
     * 诊断报告分析推送
    * @author 李志伟
    * @date 2018年12月4日 下午12:38:14
    * @param openId         微信授权码
    * @param projectName    测评项目名称    
    * @param storeName      门店信息
    * @param id             报告索引
    * @return
     */
    public boolean msgTestDateFinishMsg(String openId, String projectName, String storeName, Integer id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", testDateFinishMsg);
        requestBody.put("url", App.System.SERVER_BASE_URL + "/" + RouteConfig.WechatUser.VIEW_ORDER_UCD_ALL_READY_QUERY + "?orderId=" + id);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "您好，您的诊断报告已出具。");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", storeName);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", DateUtil.getCurDateTrimMinutes());
        requestData.put("keyword2", k2);
        Map<String, String> k3 = new HashMap<>();
        k3.put("value", "完成报告分析");
        requestData.put("keyword3", k3);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "精准报告分析，请入" + storeName + "进行查询");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    
    /**
     * 门店下单，请求会员支付通知
    * @author 李志伟
    * @date 2018年12月4日 下午1:22:23
    * @param openId     微信授权码
    * @param orderNo    订单编号
    * @param money      订单金额
    * @param id         订单索引
    * @return           发送状态
     */
    public boolean orderNeedPayMsg(String openId, String orderNo, String money, Integer id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", orderNeedPayMsg);
        requestBody.put("url", App.System.SERVER_BASE_URL + "/" + RouteConfig.WechatUser.WECHAT_APP_PAY_FOR_ORDER + "?orderId=" + id);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "您好，您已下单成功。");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", orderNo);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", money + "元");
        requestData.put("keyword2", k2);
        Map<String, String> k3 = new HashMap<>();
        k3.put("value", "微信支付(等待支付)");
        requestData.put("keyword3", k3);
        Map<String, String> k4 = new HashMap<>();
        k4.put("value", "等待组合生产发货");
        requestData.put("keyword4", k4);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "点击【详情】进行支付订单");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    
    
    /**
     * 测评订单支付完成通知
    * @author 李志伟
    * @date 2018年12月4日 下午12:21:29
    * @param openId         微信用户授权码
    * @param orderNo        订单标号
    * @param money          费用
    * @param userName       客户名称
    * @param id             订单索引ID
    * @return               发送状态
     */
    public boolean orderMoneyPaySuccessMsg(String openId, String orderNo, String money, String userName, Integer id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", testDateMoneyPaySuccessMsg);
        requestBody.put("url", null);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "订单支付完成，系统变更订单成功");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", userName);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", orderNo);
        requestData.put("keyword2", k2);
        Map<String, String> k3 = new HashMap<>();
        k3.put("value", orderNo);
        requestData.put("keyword3", k3);
        Map<String, String> k4 = new HashMap<>();
        k4.put("value", money + "元");
        requestData.put("keyword4", k4);
        Map<String, String> k5 = new HashMap<>();
        k5.put("value", DateUtil.getCurDateTrimMinutes());
        requestData.put("keyword5", k5);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "点击【详情】查看订单信息详情");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
    
    /**
     * 订单状态实时推送提醒
    * @author 李志伟
    * @date 2018年12月4日 下午1:14:35
    * @param openId         微信授权码
    * @param orderNo        订单编号
    * @param orderStatus    订单状态    
    * @param id             订单ID
    * @return               发送状态
     */
    public boolean orderStatusMsg(String openId, String orderNo, String orderStatus, Integer id) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("touser", openId);
        requestBody.put("template_id", orderStatusMsg);
        requestBody.put("url", null);
        JSONObject requestData = new JSONObject();
        Map<String, String> first = new HashMap<>();
        first.put("value", "您好，您的订单有更新变更：");
        requestData.put("first", first);
        Map<String, String> k1 = new HashMap<>();
        k1.put("value", orderNo);
        requestData.put("keyword1", k1);
        Map<String, String> k2 = new HashMap<>();
        k2.put("value", orderStatus);
        requestData.put("keyword2", k2);
        Map<String, String> remark = new HashMap<>();
        remark.put("value", "如有问题，请与销售联系。");
        requestData.put("remark", remark);
        requestBody.put("data", requestData);
        HttpClientUtil.sendPostReq(wechatMsgPostPath + getAccessToken(), requestBody.toString());
        return false;
    }
    
}
