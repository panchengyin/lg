package com.lg.dao;

import org.apache.ibatis.annotations.Param;

import com.lg.pojo.SysUserRole;

public interface ISysUserRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
    
    int deleteByUserId(@Param("userId")Integer userId);
}