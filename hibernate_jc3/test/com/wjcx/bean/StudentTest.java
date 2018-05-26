package com.wjcx.bean;



import org.hibernate.Session;

import org.hibernate.Transaction;

import org.junit.Test;

import com.wjcx.utils.HbnUtil;

public class StudentTest {
	
	//CRUD_������ݰ���1
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
	
	//CRUD_������ݰ���2
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
	
	//CRUD_ɾ�����ݰ���
	/**
	 * ɾ���ײ����id�޸ģ���ָ���޸Ķ��������id����
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
	
	//CRUD_��ӻ��޸����ݰ���
	/**
	 * �ײ����id�޸ģ���ָ���޸Ķ��������id����
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
	
	//CRUD_�޸����ݰ���
	/**
	 * ͨ�������Ƿ����id�����ж�save()����update(),��
	 * ������id,�����ݿ��û�ж�Ӧid,�����쳣
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
	
	//CRUD_��ѯ���ݰ���1--get()
	/**
	 * ��ѯ�޽��ʱ�������null�������쳣
	 * */
	@Test
	public void testGet(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//Student stu=session.get(Student.class, 1);
			
			//û��idΪ90�Ķ���
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
	
	//CRUD_��ѯ���ݰ���2--load()
	/**
	 * ��ѯ�޽��ʱ�������쳣 org.hibernate.ObjectNotFoundException
	 * No row with the given identifier exists
	 * */
	@Test
	public void testLoad(){
		Session session=HbnUtil.getSession();
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//Student stu=session.load(Student.class, 1);
			
			//û��idΪ90�Ķ���
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
	
	//CRUD_����ɾ�������ݵײ�sqlִ��˳����԰���1
	/**
	 * ���ڲ�ͬ�������������ɾ���Ĳ�����������������д���˳����Σ�
	 * �ײ�sql��ִ��˳����insert,update,delete.
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
	
	
	//CRUD_����ɾ�������ݵײ�sqlִ��˳����԰���2
	/**
	 * �޸ĵײ�sql��ִ��˳�򣬿�ͨ��session��flush()����ˢ��session��ɡ�
	 * flush()��ʹ��ǰ��ָ�Ϊ�����֣������ֻᰴ�������ġ�ɾִ��.
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
