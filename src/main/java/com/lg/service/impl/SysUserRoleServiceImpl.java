package com.lg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lg.core.web.JsonData;
import com.lg.core.web.JsonInfo;
import com.lg.dao.ISysRoleDao;
import com.lg.dao.ISysUserRoleDao;
import com.lg.pojo.SysUserRole;
import com.lg.service.ISysUserRoleService;
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

	@Resource
	private ISysUserRoleDao sys;
	
	@Override
	public JsonData insert(SysUserRole record) {
		JsonData json=new JsonData();
		sys.deleteByUserId(Integer.valueOf(record.getUserId()));
		if(sys.insert(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData deleteByUserId(String userId) {
		JsonData json=new JsonData();
		if(sys.deleteByUserId(Integer.valueOf(userId))>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.DEL_SUCCESS);
		}
		return json;
	}

}
