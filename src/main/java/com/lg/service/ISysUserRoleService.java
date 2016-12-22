package com.lg.service;

import com.lg.core.web.JsonData;
import com.lg.pojo.SysUserRole;

public interface ISysUserRoleService {
	

	public JsonData insert(SysUserRole record);
	
	public JsonData deleteByUserId(String userId);

}
