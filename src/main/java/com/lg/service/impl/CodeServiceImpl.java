package com.lg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.lg.core.web.JsonData;
import com.lg.dao.ICodeDao;
import com.lg.pojo.Code;
import com.lg.service.ICodeService;
@Service
public class CodeServiceImpl implements ICodeService {
	
	@Resource
	private ICodeDao codeDao;
	
	@Override
	public JsonData deleteByIds(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonData deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonData insert(Code record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonData insertSelective(Code record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Code selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonData updateByPrimaryKeySelective(Code record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonData updateByPrimaryKey(Code record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryByPage(String aoData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String queryList() {
		List<Code> list=codeDao.queryList();
		String json=new Gson().toJson(list);
		return json;
	}
	
}
