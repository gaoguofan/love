package com.bkn.system.entity;

public class LoveVipCoumerInfo {
    /** 索引自增 */
    private Integer infoId;

    /** 苹果包ID */
    private Integer packAgeId;

    /** 套餐名称 */
    private String packAgeName;

    /** 金额 */
    private Integer packAgeMoney;

    /** 原价 */
    private Integer packAgeOldMoney;

    /** 是否推荐 */
    private Boolean isRecommend;

    /** 最后更新时间 */
    private String updateTime;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getPackAgeId() {
        return packAgeId;
    }

    public void setPackAgeId(Integer packAgeId) {
        this.packAgeId = packAgeId;
    }

    public String getPackAgeName() {
        return packAgeName;
    }

    public void setPackAgeName(String packAgeName) {
        this.packAgeName = packAgeName == null ? null : packAgeName.trim();
    }

    public Integer getPackAgeMoney() {
        return packAgeMoney;
    }

    public void setPackAgeMoney(Integer packAgeMoney) {
        this.packAgeMoney = packAgeMoney;
    }

    public Integer getPackAgeOldMoney() {
        return packAgeOldMoney;
    }

    public void setPackAgeOldMoney(Integer packAgeOldMoney) {
        this.packAgeOldMoney = packAgeOldMoney;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}