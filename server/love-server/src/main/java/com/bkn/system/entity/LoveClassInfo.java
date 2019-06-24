package com.bkn.system.entity;

public class LoveClassInfo {
    /** 课程索引ID */
    private Integer id;

    /** 短简介 */
    private String shutText;

    /** 加粗文本 */
    private String shutStrongText;

    /** 简介图片 */
    private String shutImagePath;

    /** 发文用户头像 */
    private String personImagePath;

    /** 发文时间 */
    private String createDate;

    /** 课程内容 */
    private String articleContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShutText() {
        return shutText;
    }

    public void setShutText(String shutText) {
        this.shutText = shutText == null ? null : shutText.trim();
    }

    public String getShutStrongText() {
        return shutStrongText;
    }

    public void setShutStrongText(String shutStrongText) {
        this.shutStrongText = shutStrongText == null ? null : shutStrongText.trim();
    }

    public String getShutImagePath() {
        return shutImagePath;
    }

    public void setShutImagePath(String shutImagePath) {
        this.shutImagePath = shutImagePath == null ? null : shutImagePath.trim();
    }

    public String getPersonImagePath() {
        return personImagePath;
    }

    public void setPersonImagePath(String personImagePath) {
        this.personImagePath = personImagePath == null ? null : personImagePath.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}