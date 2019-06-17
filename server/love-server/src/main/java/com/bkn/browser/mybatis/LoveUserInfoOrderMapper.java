package com.bkn.browser.mybatis;

import com.bkn.system.entity.LoveUserInfoOrder;

public interface LoveUserInfoOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(LoveUserInfoOrder record);

    int insertSelective(LoveUserInfoOrder record);

    LoveUserInfoOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(LoveUserInfoOrder record);

    int updateByPrimaryKey(LoveUserInfoOrder record);
}