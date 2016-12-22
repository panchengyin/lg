package com.lg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lg.core.utils.EHCache;
import com.lg.core.utils.MD5Util;
import com.lg.core.utils.TcpipUtil;
import com.lg.core.web.JsonData;
import com.lg.pojo.SysUser;
import com.lg.service.ISysUserService;

@Controller
@RequestMapping("/sysUserController")
public class SysUserController {
	
	private static Logger log = Logger.getLogger(SysUserController.class);
	
	@Autowired
	HttpServletRequest request;
	
	@Resource
	private ISysUserService sysUserService;

	/***
	 * 分页查询
	 * @param aoData
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String getItemList(@RequestParam String aoData){  
        return this.sysUserService.queryByPage(aoData);  
    }  
   	/***
   	 * 新增方法
   	 * @param po
   	 * @return
   	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData add(@ModelAttribute SysUser po) {
		po.setPassword(MD5Util.string2MD5(po.getPassword()));//加密密码
		po.setRegIp(TcpipUtil.getIpAddr(request));//IP
		po.setRegTime(new Date());//创建日期
		return this.sysUserService.insert(po);
	}
	/**
	 * 更新提交
	 * @param request
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData editSubmit(@ModelAttribute SysUser po)throws Exception{
		po.setLastLoginTime(new Date());//更新日期
		po.setLastLoginIp(TcpipUtil.getIpAddr(request));//更新IP
		return this.sysUserService.updateByPrimaryKeySelective(po);
	}
	/***
	 * 根据ID删除对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData deleteById(String id) {	
		return this.sysUserService.deleteByIds(id.split(","));
	}
	
	
	/***
	 * 根据ID找到对象
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "findById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public SysUser findById(String id)throws Exception{
		return this.sysUserService.selectByPrimaryKey(Integer.valueOf(id));
	}

}
