package com.bkn.system.entity;

public class LoveUserInfo {
    /**  */
    private Integer userId;

    /**  */
    private String phone;

    /**  */
    private String wechatOpenId;

    /**  */
    private Boolean isVip;

    /**  */
    private String vipExprise;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId == null ? null : wechatOpenId.trim();
    }

    public Boolean getIsVip() {
        return isVip;
    }

    public void setIsVip(Boolean isVip) {
        this.isVip = isVip;
    }

    public String getVipExprise() {
        return vipExprise;
    }

    public void setVipExprise(String vipExprise) {
        this.vipExprise = vipExprise == null ? null : vipExprise.trim();
    }
}