package com.wjcx.bean;



import org.hibernate.Session;

import org.hibernate.Transaction;

import org.junit.Test;

import com.wjcx.utils.HbnUtil;

public class StudentTest {
	
	//CRUD_添加数据案例1
	@Test
	public void testSave(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		Student student=new Student();
		student.setName("Natsy");
		student.setAge(22);
		student.setScore(84.8);
		
		try {
			transaction.begin();
			session.save(student);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_添加数据案例2
	@Test
	public void testPersist(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		Student student=new Student();
		student.setName("Jack");
		student.setAge(20);
		student.setScore(80);
		
		try {
			transaction.begin();
			session.persist(student);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_删除数据案例
	/**
	 * 删除底层根据id修改，故指定修改对象必须有id属性
	 * */
	@Test
	public void testDelete(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		Student student=new Student();
		student.setId(3);
		
		try {
			transaction.begin();
			session.delete(student);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_添加或修改数据案例
	/**
	 * 底层根据id修改，故指定修改对象必须有id属性
	 * */
	@Test
	public void testUpdate(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		Student student=new Student();
		student.setName("Helen");
		student.setAge(21);
		student.setScore(85);
		student.setId(2);
		try {
			transaction.begin();
			session.update(student);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_修改数据案例
	/**
	 * 通过对象是否具有id属性判断save()还是update(),若
	 * 对象有id,而数据库表没有对应id,则抛异常
	 * */
	@Test
	public void testSaveOrUpdate(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		Student student=new Student();
		student.setName("Jackson");
		student.setAge(23);
		student.setScore(85);
		student.setId(3);
		try {
			transaction.begin();
			session.saveOrUpdate(student);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_查询数据案例1--get()
	/**
	 * 查询无结果时，会给出null，不抛异常
	 * */
	@Test
	public void testGet(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//Student stu=session.get(Student.class, 1);
			
			//没有id为90的对象
			Student stu=session.get(Student.class, 90);
			System.out.println(stu);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_查询数据案例2--load()
	/**
	 * 查询无结果时，会抛异常 org.hibernate.ObjectNotFoundException
	 * No row with the given identifier exists
	 * */
	@Test
	public void testLoad(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//Student stu=session.load(Student.class, 1);
			
			//没有id为90的对象
			Student stu=session.load(Student.class, 90);
			System.out.println(stu);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	//CRUD_增、删、改数据底层sql执行顺序测试案例1
	/**
	 * 对于不同操作对象的增，删，改操作，无论其代码的书写语句顺序如何，
	 * 底层sql的执行顺序都是insert,update,delete.
	 * */
	@Test
	public void testIDU_1(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			
			//delete
			Student stu1=session.load(Student.class, 4);
			session.delete(stu1);
			//update
			Student stu2=session.load(Student.class, 1);
			stu2.setScore(88.8);
			session.update(stu2);
			//insert
			Student stu3=new Student();
			stu3.setName("HanMeimei");
			stu3.setScore(80);
			stu3.setAge(20);
			session.save(stu3);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	
	//CRUD_增、删、改数据底层sql执行顺序测试案例2
	/**
	 * 修改底层sql的执行顺序，可通过session的flush()方法刷新session完成。
	 * flush()会使其前后分割为两部分，各部分会按照增、改、删执行.
	 * */
	@Test
	public void testIDU_2(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			
			//delete
			Student stu1=session.load(Student.class, 5);
			session.delete(stu1);
			//update
			Student stu2=session.load(Student.class, 2);
			stu2.setScore(87.7);
			session.update(stu2);
			
			session.flush();
			//insert
			Student stu3=new Student();
			stu3.setName("LiLei");
			stu3.setScore(82);
			stu3.setAge(21);
			session.save(stu3);
			
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
			session.close();
		}
			
	}
	
	@Test
	public void test() {
		System.out.println(HbnUtil.getSession());
	}

}
