package com.wjcx.sp.service.impl;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wjcx.sp.service.UserService;

public class UserServiceImplTest {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserServiceImpl) context.getBean("userService");
		
		userService.sayHello();
	
	}
	
	@Test
	public void testInitAndDestroy() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserServiceImpl) context.getBean("userService");
		
		userService.sayHello();
		
	}
}
