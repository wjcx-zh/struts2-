package com.wjcx.hbn.bean;



import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.hbn.util.SessionUtil;

public class StudentTest2 {
	private Session session;
	private Transaction transaction;
	@Before
	public void before(){
		session=SessionUtil.getSession();
	}
	
	@After
	public void after(){
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
	}
	
	@Test
	public void testInsert() {
		
		
		transaction=session.beginTransaction();
		//数据库操作
		Student student=new Student();
		student.setStuname("Kazaf");
		student.setScore(80.0);
		student.setAge(23);
		
		//保存
		session.save(student);
		
	}
	
	@Test
	public void testDelete() {
		
		
		transaction=session.beginTransaction();
		//数据库操作
		Student student=session.get(Student.class, 1);
		System.out.println(student.getStuname());
		session.delete(student);
		
	}
	@Test
	public void testUpdate() {
		
		
		transaction=session.beginTransaction();
		//数据库操作
		Student student=session.get(Student.class, 2);
		student.setScore(78.9);
		student.setAge(24);
		System.out.println(student.getStuname());
		session.update(student);;
		
	}
	
	@Test
	public void selectAll(){
		transaction=session.beginTransaction();
		Query query=session.createQuery("from Student");
		List<Student> list=query.list();
		for(Student obj:list){
			System.out.println(obj);
		}
		//return ;
	}
}
