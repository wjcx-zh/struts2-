package com.wjcx.sp.bean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wjcx.sp.dao.UserDao;
import com.wjcx.sp.service.UserService;
import com.wjcx.sp.service.impl.UserServiceImpl;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person)context.getBean("person");
		System.out.println(person.toString());
	}

	@Test
	public void testCourse() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Course person=(Course)context.getBean("course1");
		System.out.println(person.toString());
	}
	
	@Test
	public void testTeacher() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Teacher teacher=(Teacher)context.getBean("teacher");
		System.out.println(teacher.toString());
	}
	@Test
	public void testStudent() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student=(Student)context.getBean("student1",Student.class);
		
		System.out.println(student.toString());
	}
	@Test
	public void testService() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service=(UserService)context.getBean("userService",UserServiceImpl.class);
		service.sayHello();
	
	}
	@Test
	public void testDao() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao service=(UserDao)context.getBean("udao",UserDao.class);
		service.dao();;
	
	}
}
