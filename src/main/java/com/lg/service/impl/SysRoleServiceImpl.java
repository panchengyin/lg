package com.lg.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lg.core.utils.DateUtils;
import com.lg.core.utils.MapUtil;
import com.lg.core.utils.PageUtils;
import com.lg.core.web.DataGrid;
import com.lg.core.web.JsonData;
import com.lg.core.web.JsonInfo;
import com.lg.dao.ISysRoleDao;
import com.lg.dao.ISysRoleDao;
import com.lg.pojo.SysRole;
import com.lg.service.ISysRoleService;
import com.lg.service.ISysRoleService;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

	@Resource
	private ISysRoleDao sys;

	
	@Override
	public String queryByPage(String aoData) {
		
		HashMap<String,String> aoDataMap=MapUtil.aoDataToMap(aoData);
		
		String sEcho =aoDataMap.get("sEcho");// 记录操作的次数 每次加1
		String txt_search=aoDataMap.get("txt_search");//搜索条件
		int iDisplayStart = Integer.parseInt(aoDataMap.get("iDisplayStart"));// 起始
		int iDisplayLength =Integer.parseInt(aoDataMap.get("iDisplayLength"));// size
		
		int startPage=PageUtils.CountToPageNum(iDisplayStart, iDisplayLength);
		PageHelper.startPage(startPage,iDisplayLength);
		
		List<SysRole> list = sys.queryListPage(txt_search);
		
		PageInfo<SysRole> page = new PageInfo<SysRole>(list);
		
		DataGrid dg=new DataGrid(sEcho, page.getTotal(), list);
		Gson gson = new GsonBuilder().setDateFormat(DateUtils.Y_M_DHMS).create(); 
	    return gson.toJson(dg);
	}  
	
	@Override
	public String selectAll(){
		List<SysRole> list =sys.selectAll();
		Gson gson = new GsonBuilder().setDateFormat(DateUtils.Y_M_DHMS).create(); 
	    return gson.toJson(list);
	}
	
	@Override
	public JsonData deleteByIds(String[] ids) {
		JsonData json=new JsonData();
		if(sys.deleteByIds(ids)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.DEL_SUCCESS);
		}
		return json;
	}
	
	@Override
	public JsonData deleteByPrimaryKey(Integer id) {
		JsonData json=new JsonData();
		if(sys.deleteByPrimaryKey(id)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.DEL_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData insert(SysRole record) {
		JsonData json=new JsonData();
		if(sys.insert(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData insertSelective(SysRole record) {
		JsonData json=new JsonData();
		if(sys.insertSelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public SysRole selectByPrimaryKey(Integer id) {
		
		return sys.selectByPrimaryKey(id);
	}

	@Override
	public JsonData updateByPrimaryKeySelective(SysRole record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKeySelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData updateByPrimaryKey(SysRole record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKey(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	
}
