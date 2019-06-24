package com.bkn.browser.mybatis;

import java.util.List;

import com.bkn.system.entity.LoveClassInfo;

public interface LoveClassInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveClassInfo record);

    int insertSelective(LoveClassInfo record);

    LoveClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveClassInfo record);

    int updateByPrimaryKeyWithBLOBs(LoveClassInfo record);

    int updateByPrimaryKey(LoveClassInfo record);

    List<LoveClassInfo> selectAll();
}