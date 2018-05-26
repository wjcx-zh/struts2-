package com.wjcx.link;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.News;
import com.wjcx.utils.HbnUtil;


/**
 * �Թ��������
 * */
public class SelfLinkTest {
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
	public void testSelf1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	
	@Test
	public void testSelf2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			News footballNews=new News("������Ŀ");
			footballNews.setContent("football....");
			
			News basketballNews=new News("������Ŀ");
			basketballNews.setContent("basketball....");
			
			News sportNews=new News("������Ŀ");
			sportNews.setContent("sport....");
			
			sportNews.getChildrenNews().add(footballNews);
			sportNews.getChildrenNews().add(basketballNews);
			
			session.save(sportNews);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
