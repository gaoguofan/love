package com.bkn.system.entity;

public class LoveLiaobeiAnswer {
    /** 回答ID */
    private Integer answerId;

    /** 回答内容 */
    private String answerDesc;

    /** 问题ID */
    private Integer questionId;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc == null ? null : answerDesc.trim();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}