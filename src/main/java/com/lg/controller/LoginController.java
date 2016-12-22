package com.lg.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lg.core.utils.MD5Util;
import com.lg.pojo.SysUser;
import com.lg.service.ISysUserService;
@Controller
@RequestMapping("/loginController")
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private ISysUserService sysUserService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ModelAndView login(HttpSession session,String username, String password) {

		SysUser user = this.sysUserService.loginVerification(username, MD5Util.string2MD5(password));
		Map<String, Object> model = new HashMap<String, Object>();
		if (user != null) {
			session.setAttribute("user", user);
			model.put("user", user);
			log.warn("登录成功!");
			return new ModelAndView("pages/main/main", model);
		} else {
			model.put("error", "用户名或密码输入错误!");
			log.warn("登录失败!");
			return new ModelAndView("login", model);
		}
	}
}
