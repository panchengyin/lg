package com.lg.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lg.pojo.SysRole;

public interface ISysRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    int deleteByIds(@Param("ids") String[] ids);

    List<SysRole> queryListPage(@Param("search") String txt_search);
    
    List<SysRole> selectAll();
    
}