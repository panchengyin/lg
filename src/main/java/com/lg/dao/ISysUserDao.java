package com.lg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lg.pojo.SysUser;

public interface ISysUserDao {
	

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    int deleteByIds(@Param("ids") String[] ids);

    List<SysUser> queryListPage(@Param("begTime") String begTime,@Param("endTime") String endTime,@Param("search") String txt_search);
    
    SysUser loginVerification(@Param("userName")String userName,@Param("password")String password);
 
}