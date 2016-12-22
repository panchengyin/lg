package com.lg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lg.pojo.SysRoleResource;

public interface ISysRoleResourceDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);

    SysRoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleResource record);

    int updateByPrimaryKey(SysRoleResource record);
    
    int insertBatch(List<SysRoleResource> record);
    
    int deleteByRoleId(@Param("roleId") Integer roleId);
}