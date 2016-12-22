package com.lg.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lg.service.ICodeService;


@Controller
@RequestMapping("/codeController")
public class CodeController {
	
	private static Logger log = Logger.getLogger(SysUserController.class);
	
	@Resource
	private ICodeService codeService;
	/***
	 * 查询列表
	 * @param aoData
	 * @return
	 */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody  
    public String getItemList(){  
        return this.codeService.queryList();
    }  
}
