package com.bkn.browser.mybatis;

import org.apache.ibatis.annotations.Param;

import com.bkn.system.entity.LoveUserInfo;

public interface LoveUserInfoMapper {
    
    int deleteByPrimaryKey(Integer userId);

    int insert(LoveUserInfo record);

    int insertSelective(LoveUserInfo record);

    LoveUserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(LoveUserInfo record);

    int updateByPrimaryKey(LoveUserInfo record);

    LoveUserInfo selectByWechatId(@Param("wechatOpenId") String openId);
    
    LoveUserInfo selectByPhone(@Param("phone") String phone);
}