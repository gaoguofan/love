package com.bkn.system.entity;

import java.util.List;

public class LoveCategoryInfo {
    
    /** 自增索引ID */
    private Integer id;

    /** 文本内容 */
    private String infoText;

    /** 上级索引ID */
    private Integer parentId;
    
    /** 子列表信息 */
    private List<LoveCategoryInfo> loveCategoryInfos;
    
    public List<LoveCategoryInfo> getLoveCategoryInfos() {
        return loveCategoryInfos;
    }

    public void setLoveCategoryInfos(List<LoveCategoryInfo> loveCategoryInfos) {
        this.loveCategoryInfos = loveCategoryInfos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText == null ? null : infoText.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}