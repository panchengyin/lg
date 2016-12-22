package com.lg.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lg.core.web.JsonData;
import com.lg.core.web.JsonInfo;
import com.lg.dao.ISysRoleResourceDao;
import com.lg.pojo.SysRoleResource;
import com.lg.service.ISysRoleResourceService;

@Service
public class SysRoleResourceServiceImpl implements ISysRoleResourceService {

	@Resource
	private ISysRoleResourceDao sys;

	
	@Override
	public JsonData insertBatch(String roleId,String resourceIds){
		JsonData json=new JsonData();
		String[] arr = resourceIds.split(","); 
		List<SysRoleResource> record=new ArrayList<SysRoleResource>();
		SysRoleResource s;
		for(int i=0;i<arr.length;i++){
			s=new SysRoleResource();
			s.setRoleId(Integer.valueOf(roleId));
			s.setResourceId(Integer.valueOf(arr[i]));
			record.add(s);
		}
		sys.deleteByRoleId(Integer.valueOf(roleId));
		if(sys.insertBatch(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		
		return json;
	}
	
	@Override
	public JsonData deleteByRoleId(String roleId) {
		JsonData json=new JsonData();
		if(sys.deleteByRoleId(Integer.valueOf(roleId))>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.DEL_SUCCESS);
		}
		return json;
	}
	
}
