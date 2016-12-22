package com.lg.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.core.web.JsonData;
import com.lg.pojo.SysRole;
import com.lg.service.ISysRoleService;
import com.lg.service.ISysUserRoleService;
@Controller
@RequestMapping("/sysRoleController")
public class SysRoleController {

private static Logger log = Logger.getLogger(SysRoleController.class);
	
	@Autowired
	HttpServletRequest request;
	
	@Resource
	private ISysRoleService sysRoleService;
	
	@Resource
	private ISysUserRoleService sysUserRoleService;
	
	/***
	 * 分页查询
	 * @param aoData
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String getItemList(@RequestParam String aoData){  
        return this.sysRoleService.queryByPage(aoData);  
    }  
	/***
	 * 获取启用的角色列表
	 * @return
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String selectAll(){  
        return this.sysRoleService.selectAll();  
    }
	/***
	 * 获取启用的角色列表
	 * @return
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String selectAl1l(){  
        return this.sysRoleService.selectAll();  
    }
	
   	/***
   	 * 新增方法
   	 * @param po
   	 * @return
   	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData add(@ModelAttribute SysRole po) {
		po.setCreateTime(new Date());//创建日期
		return this.sysRoleService.insert(po);
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
	public JsonData editSubmit(@ModelAttribute SysRole po)throws Exception{
		po.setModifyTime(new Date());//更新日期
		return this.sysRoleService.updateByPrimaryKeySelective(po);
	}
	/***
	 * 根据ID删除对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData deleteById(String id) {	
		return this.sysRoleService.deleteByIds(id.split(","));
	}
	
	
	/***
	 * 根据ID找到对象
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "findById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public SysRole findById(String id)throws Exception{
		return this.sysRoleService.selectByPrimaryKey(Integer.valueOf(id));
	}

}
