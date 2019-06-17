package com.bkn.browser.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bkn.system.entity.LoveLiaobeiQuestion;

public interface LoveLiaobeiQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(LoveLiaobeiQuestion record);

    int insertSelective(LoveLiaobeiQuestion record);

    LoveLiaobeiQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(LoveLiaobeiQuestion record);

    int updateByPrimaryKey(LoveLiaobeiQuestion record);

    List<LoveLiaobeiQuestion> selectByKeyAndPageInfo(@Param("key") String key);
}