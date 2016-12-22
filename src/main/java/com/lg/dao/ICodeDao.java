package com.lg.dao;

import java.util.List;

import com.lg.pojo.Code;

public interface ICodeDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Code record);

    int insertSelective(Code record);

    Code selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
    
    List<Code> queryList();
}