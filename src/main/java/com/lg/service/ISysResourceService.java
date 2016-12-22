package com.lg.service;

import com.lg.core.web.JsonData;
import com.lg.pojo.SysResource;

public interface ISysResourceService {
	
	
	public JsonData deleteByIds(String[] ids);
	
	public JsonData deleteByPrimaryKey(Integer id);

	public JsonData insert(SysResource record);

    public JsonData insertSelective(SysResource record);

    public SysResource selectByPrimaryKey(Integer id);

    public JsonData updateByPrimaryKeySelective(SysResource record);

    public JsonData updateByPrimaryKey(SysResource record);
    
    public String queryByPage(String aoData); 
    
    public String getTreeJson(String roleId);
}
