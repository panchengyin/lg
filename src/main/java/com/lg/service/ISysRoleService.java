package com.lg.service;

import java.util.List;

import com.lg.core.web.JsonData;
import com.lg.pojo.SysRole;

public interface ISysRoleService {
	

	public JsonData deleteByIds(String[] ids);
	
	public JsonData deleteByPrimaryKey(Integer id);

	public JsonData insert(SysRole record);

    public JsonData insertSelective(SysRole record);

    public SysRole selectByPrimaryKey(Integer id);

    public JsonData updateByPrimaryKeySelective(SysRole record);

    public JsonData updateByPrimaryKey(SysRole record);
    
    public String queryByPage(String aoData); 
    
    public String selectAll();
}
