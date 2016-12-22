package com.lg.service;

import java.util.List;

import com.lg.core.web.JsonData;
import com.lg.pojo.Code;

public interface ICodeService {
	
	public JsonData deleteByIds(String[] ids);
	
	public JsonData deleteByPrimaryKey(Integer id);

	public JsonData insert(Code record);

    public JsonData insertSelective(Code record);

    public Code selectByPrimaryKey(Integer id);

    public JsonData updateByPrimaryKeySelective(Code record);

    public JsonData updateByPrimaryKey(Code record);
    
    public String queryByPage(String aoData); 
    
    public String queryList();
}
