package com.wjcx.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.Student;
import com.wjcx.utils.HbnUtil;

public class CacheTest {
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
	public void testCache1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	
	//���Կ���
	@Test
	public void testCache2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//ִ�в�ѯ���Ὣ���������session����,���ڿ����б���һ������
			Student stu=session.get(Student.class, 1);
			System.out.println(stu);
			//�޸�����
			stu.setScore(87.88);
			System.out.println(stu);
			//�ύʱ����������ݶԱ�,���ݲ�ͬ,ִ��update,��ͬʱ�ڿ����б���һ�ݸ���.
			//transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	
}
