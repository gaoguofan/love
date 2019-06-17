package com.bkn.system.entity;

public class LoveUserInfo {
    /**  */
    private Integer userId;

    /** 手机号码 */
    private String phone;

    /** 微信表示 */
    private String wechatOpenId;

    /** 性别 */
    private String sex;

    /** 微信昵称 */
    private String userName;

    /** 头像地址 */
    private String imagePath;

    /** 是否vip */
    private Boolean isVip;

    /** 过期时间 */
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
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