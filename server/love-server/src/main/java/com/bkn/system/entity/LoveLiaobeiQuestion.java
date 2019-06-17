package com.bkn.system.entity;

import java.util.List;

public class LoveLiaobeiQuestion {
    
    /** 问题ID */
    private Integer questionId;

    /** 问题搜索计数 */
    private Integer searchCount;

    /** 问题内容 */
    private String questionDesc;

    /** 问题标签 */
    private String questionTags;

    /** 下一条问题编号，-1为无下条 */
    private Integer questionNext;

    /** 导师信息 */
    private Integer tutorId;
    
    /** 回复 */
    private List<LoveLiaobeiAnswer> answers;

    /** 下一条问题 */
    private LoveLiaobeiQuestion question;

    
    public List<LoveLiaobeiAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<LoveLiaobeiAnswer> answers) {
        this.answers = answers;
    }

    public LoveLiaobeiQuestion getQuestion() {
        return question;
    }

    public void setQuestion(LoveLiaobeiQuestion question) {
        this.question = question;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc == null ? null : questionDesc.trim();
    }

    public String getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(String questionTags) {
        this.questionTags = questionTags == null ? null : questionTags.trim();
    }

    public Integer getQuestionNext() {
        return questionNext;
    }

    public void setQuestionNext(Integer questionNext) {
        this.questionNext = questionNext;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }
}