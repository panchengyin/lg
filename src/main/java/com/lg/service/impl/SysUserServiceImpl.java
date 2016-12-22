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
import com.lg.dao.ISysUserDao;
import com.lg.pojo.SysUser;
import com.lg.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {

	@Resource
	private ISysUserDao sys;
	
	public SysUser loginVerification(String userName,String passWord){
		return sys.loginVerification(userName, passWord);
	}
	
	@Override
	public String queryByPage(String aoData) {
		
HashMap<String,String> aoDataMap=MapUtil.aoDataToMap(aoData);
		
		String sEcho =aoDataMap.get("sEcho");// 记录操作的次数 每次加1
		String txt_search=aoDataMap.get("txt_search");//搜索条件
		String begTime="";//开始时间
		String endTime="";//结束时间
		int iDisplayStart = Integer.parseInt(aoDataMap.get("iDisplayStart"));// 起始
		int iDisplayLength =Integer.parseInt(aoDataMap.get("iDisplayLength"));// size
		
     	
		if(begTime.length()>0)begTime+=" 00:00:00";
		if(endTime.length()>0)endTime+=" 23:59:59";
		
		int startPage=PageUtils.CountToPageNum(iDisplayStart, iDisplayLength);
		PageHelper.startPage(startPage,iDisplayLength);
		
		List<SysUser> list = sys.queryListPage(begTime,endTime,txt_search);
		
		PageInfo<SysUser> page = new PageInfo<SysUser>(list);
		
		DataGrid dg=new DataGrid(sEcho, page.getTotal(), list);
		Gson gson = new GsonBuilder().setDateFormat(DateUtils.Y_M_DHMS).create(); 
	    return gson.toJson(dg);
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
	public JsonData insert(SysUser record) {
		JsonData json=new JsonData();
		if(sys.insert(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData insertSelective(SysUser record) {
		JsonData json=new JsonData();
		if(sys.insertSelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public SysUser selectByPrimaryKey(Integer id) {
		
		return sys.selectByPrimaryKey(id);
	}

	@Override
	public JsonData updateByPrimaryKeySelective(SysUser record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKeySelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData updateByPrimaryKey(SysUser record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKey(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	
}
