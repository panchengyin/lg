package com.lg.controller;

import java.util.Date;
import java.util.List;

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
import com.lg.pojo.SysResource;
import com.lg.service.ISysResourceService;
import com.lg.service.ISysRoleResourceService;
@Controller
@RequestMapping("/sysResourceController")
public class SysResourceController {

private static Logger log = Logger.getLogger(SysResourceController.class);
	
	@Autowired
	HttpServletRequest request;
	
	@Resource
	private ISysResourceService sysResourceService;

	@Resource
	private ISysRoleResourceService sysRoleResourceService;
	
 	/***
   	 * 批量插入
   	 * @param po
   	 * @return
   	 */
	@RequestMapping(value = "/batchAdd", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData batchAdd(String roleId,String resourceIds) {
		return this.sysRoleResourceService.insertBatch(roleId, resourceIds);
	}

	/***
	 * 通过角色删除资源
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delByRoleId", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData delByRoleId(String id)throws Exception{
		return this.sysRoleResourceService.deleteByRoleId(id);
	}
	
	/***
	 * 获取权限树
	 * @return
	 */
	@RequestMapping(value = "/getTree", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody  
	public String getTreeJson(@RequestParam String roleId){
		return this.sysResourceService.getTreeJson(roleId);  
	}
	/***
	 * 分页查询
	 * @param aoData
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String getItemList(@RequestParam String aoData){  
        return this.sysResourceService.queryByPage(aoData);  
    }  
   	/***
   	 * 新增方法
   	 * @param po
   	 * @return
   	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData add(@ModelAttribute SysResource po) {
		po.setCreateTime(new Date());//创建日期
		return this.sysResourceService.insert(po);
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
	public JsonData editSubmit(@ModelAttribute SysResource po)throws Exception{
		po.setModifyTime(new Date());//更新日期
		return this.sysResourceService.updateByPrimaryKeySelective(po);
	}
	/***
	 * 根据ID删除对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonData deleteById(String id) {	
		return this.sysResourceService.deleteByIds(id.split(","));
	}
	
	
	/***
	 * 根据ID找到对象
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "findById", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public SysResource findById(String id)throws Exception{
		return this.sysResourceService.selectByPrimaryKey(Integer.valueOf(id));
	}

}
