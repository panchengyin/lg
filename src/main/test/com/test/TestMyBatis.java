package com.test;


import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	@Resource
//	private IUserService userService = null;
//	@Test
//	public void test1() {
//		User user = userService.getUserById(1);
//		String str=JSON.toJSONString(user);
//		System.out.print(str);
//	}
}
