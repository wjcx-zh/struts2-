package com.wjcx.link;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.Course;

import com.wjcx.bean.Student1;
import com.wjcx.utils.HbnUtil;

public class ManyToManyTest {
	private Session session;
	
	@Before
	public void before(){
		session=HbnUtil.getSession();
	}
	
	@After
	public void after(){
		session.close();
	}
	
	@Test
	public void testMtoM1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//˫�����
	@Test
	public void testMtoM3(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Course course1=new Course("Spring");
			Course course2=new Course("Hadoop");
			
			Student1 stu=new Student1("LinYang");
			//stu.getCourses().add(course1);
			//stu.getCourses().add(course2);
			course1.getStudents().add(stu);
			course2.getStudents().add(stu);
			//session.save(course1);
			//session.save(course2);
			session.save(stu);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	@Test
	public void testMtoM2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Course course1=new Course("Struts2");
			Course course2=new Course("Hibernate");
			
			Student1 stu=new Student1("Ziv");
			stu.getCourses().add(course1);
			stu.getCourses().add(course2);
			
			session.save(stu);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
}
