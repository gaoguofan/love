package com.bkn.browser.mybatis;

import java.util.List;

import com.bkn.system.entity.LoveLiaobeiAnswer;

public interface LoveLiaobeiAnswerMapper {
    
    int deleteByPrimaryKey(Integer answerId);

    int insert(LoveLiaobeiAnswer record);

    int insertSelective(LoveLiaobeiAnswer record);

    LoveLiaobeiAnswer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(LoveLiaobeiAnswer record);

    int updateByPrimaryKey(LoveLiaobeiAnswer record);
    
    List<LoveLiaobeiAnswer> selectByQuestionId(Integer questId);
}