package com.bkn.browser.mybatis;

import com.bkn.system.entity.LoveVipCoumerInfo;

public interface LoveVipCoumerInfoMapper {
    int deleteByPrimaryKey(Integer infoId);

    int insert(LoveVipCoumerInfo record);

    int insertSelective(LoveVipCoumerInfo record);

    LoveVipCoumerInfo selectByPrimaryKey(Integer infoId);

    int updateByPrimaryKeySelective(LoveVipCoumerInfo record);

    int updateByPrimaryKey(LoveVipCoumerInfo record);
}