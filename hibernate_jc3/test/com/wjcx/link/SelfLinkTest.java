package com.wjcx.link;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.News;
import com.wjcx.utils.HbnUtil;


/**
 * 自关联类测试
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
		 * 测试自动建表,对应数据库的方言要选对，否则会报错，无法建表。
		 * 对于mysql5之后的版本，方言应选MySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	
	@Test
	public void testSelf2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			News footballNews=new News("足球栏目");
			footballNews.setContent("football....");
			
			News basketballNews=new News("篮球栏目");
			basketballNews.setContent("basketball....");
			
			News sportNews=new News("体育栏目");
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
