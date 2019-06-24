package com.bkn.browser.mybatis;

import java.util.List;

import com.bkn.system.entity.LoveArticleInfo;

public interface LoveArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveArticleInfo record);

    int insertSelective(LoveArticleInfo record);

    LoveArticleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveArticleInfo record);

    int updateByPrimaryKey(LoveArticleInfo record);

    List<LoveArticleInfo> selectAll();
}