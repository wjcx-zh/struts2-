package com.wjcx.sp.bean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
