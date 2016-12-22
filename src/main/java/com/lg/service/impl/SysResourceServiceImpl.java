package com.lg.service.impl;

import java.util.ArrayList;
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
import com.lg.core.utils.StringUtil;
import com.lg.core.web.DataGrid;
import com.lg.core.web.JsonData;
import com.lg.core.web.JsonInfo;
import com.lg.core.web.TreeBuilder;
import com.lg.core.web.TreeBuilder.Node;
import com.lg.core.web.TreeBuilder.StateNode;
import com.lg.dao.ISysResourceDao;
import com.lg.pojo.SysResource;
import com.lg.service.ISysResourceService;
import com.lg.vo.SysResourceVO;

@Service
public class SysResourceServiceImpl implements ISysResourceService {

	@Resource
	private ISysResourceDao sys;

	
	@Override
	public String queryByPage(String aoData) {
		
		HashMap<String,String> aoDataMap=MapUtil.aoDataToMap(aoData);
	
		String sEcho =aoDataMap.get("sEcho");// 记录操作的次数 每次加1
		String txt_search=aoDataMap.get("txt_search");//搜索条件
		String id=aoDataMap.get("id");//ID
		int iDisplayStart = Integer.parseInt(aoDataMap.get("iDisplayStart"));// 起始
		int iDisplayLength =Integer.parseInt(aoDataMap.get("iDisplayLength"));// size
	
		int startPage=PageUtils.CountToPageNum(iDisplayStart, iDisplayLength);
		PageHelper.startPage(startPage,iDisplayLength);
		
		List<SysResourceVO> list = sys.queryListPage(id,txt_search);
		
		PageInfo<SysResourceVO> page = new PageInfo<SysResourceVO>(list);
		
		DataGrid dg=new DataGrid(sEcho, page.getTotal(), list);
	
		//Gson gson = new GsonBuilder().setDateFormat(DateUtils.Y_M_DHMS).create();
		Gson gson = new GsonBuilder().serializeNulls().create();
		
	    return gson.toJson(dg);
	}  
	@Override
	public String getTreeJson(String roleId) {
		List<SysResourceVO> list = sys.selectTreeList(roleId);
		List<Node> nodes = new ArrayList<Node>();
		if(list.size()>0){
			for(SysResourceVO s:list){ 
				 Node p;
				 if(StringUtil.isEmpty(roleId)){
					 p = new Node(s.getId().toString(),s.getParentId().toString(),s.getResourceName());
				 }else{
					 StateNode sNode=new StateNode();
					 if(s.getRoleCount().equals("0")){
						 sNode.setSelected(false);
					 }else{
						 sNode.setSelected(true);
					 }
					 p= new Node(s.getId().toString(),s.getParentId().toString(),s.getResourceName(),sNode);
				 }
				
				 nodes.add(p);
			}   
		}
		TreeBuilder treeBuilder = new TreeBuilder(nodes);
	    return treeBuilder.buildJSONTree();
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
	public JsonData insert(SysResource record) {
		JsonData json=new JsonData();
		if(sys.insert(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData insertSelective(SysResource record) {
		JsonData json=new JsonData();
		if(sys.insertSelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.ADD_SUCCESS);
		}
		return json;
	}

	@Override
	public SysResource selectByPrimaryKey(Integer id) {
		
		return sys.selectByPrimaryKey(id);
	}

	
	@Override
	public JsonData updateByPrimaryKeySelective(SysResource record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKeySelective(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	@Override
	public JsonData updateByPrimaryKey(SysResource record) {
		JsonData json=new JsonData();
		if(sys.updateByPrimaryKey(record)>0){
			json.setSuccess(true);
			json.setMsg(JsonInfo.UPD_SUCCESS);
		}
		return json;
	}

	
}
