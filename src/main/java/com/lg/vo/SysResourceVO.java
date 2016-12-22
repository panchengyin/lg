package com.lg.vo;

import com.lg.pojo.SysResource;

public class SysResourceVO extends SysResource {
	
	private String parentName;
	private String roleCount;//角色包含权限判断
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName == null ? null : parentName.trim();
	}

	public String getRoleCount() {
		return roleCount;
	}

	public void setRoleCount(String roleCount) {
		this.roleCount = roleCount;
	}
	
	
}
