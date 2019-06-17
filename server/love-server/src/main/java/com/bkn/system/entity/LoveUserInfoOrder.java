package com.bkn.system.entity;

public class LoveUserInfoOrder {
    /** 订单索引 */
    private Integer orderId;

    /** 用户ID */
    private Integer userId;

    /** 支付方式（1：微信支付 2：支付宝 3：苹果支付） */
    private Integer paySign;

    /** 支付套餐种类 */
    private Integer payCategory;

    /** 支付金额 */
    private Integer payMoney;

    /** 订单号码 */
    private String outTradeNo;

    /** 第三方订单号 */
    private String signNo;

    /** 创建时间 */
    private String createTime;

    /** 事物时间 */
    private String finishTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaySign() {
        return paySign;
    }

    public void setPaySign(Integer paySign) {
        this.paySign = paySign;
    }

    public Integer getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(Integer payCategory) {
        this.payCategory = payCategory;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getSignNo() {
        return signNo;
    }

    public void setSignNo(String signNo) {
        this.signNo = signNo == null ? null : signNo.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime == null ? null : finishTime.trim();
    }
}