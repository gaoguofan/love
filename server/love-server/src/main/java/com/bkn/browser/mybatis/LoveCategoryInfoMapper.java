package com.bkn.browser.mybatis;

import java.util.List;

import com.bkn.system.entity.LoveCategoryInfo;

public interface LoveCategoryInfoMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(LoveCategoryInfo record);

    int insertSelective(LoveCategoryInfo record);

    LoveCategoryInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveCategoryInfo record);

    int updateByPrimaryKey(LoveCategoryInfo record);
    
    List<LoveCategoryInfo> selectByParentId(Integer id);

    List<LoveCategoryInfo> selectAll();
}