package com.lg.service;

import com.lg.core.web.JsonData;
import com.lg.pojo.SysUser;

public interface ISysUserService {
	
	public SysUser loginVerification(String userName,String passWord);
	
	public JsonData deleteByIds(String[] ids);
	
	public JsonData deleteByPrimaryKey(Integer id);

	public JsonData insert(SysUser record);

    public JsonData insertSelective(SysUser record);

    public SysUser selectByPrimaryKey(Integer id);

    public JsonData updateByPrimaryKeySelective(SysUser record);

    public JsonData updateByPrimaryKey(SysUser record);
    
    public String queryByPage(String aoData); 
}
