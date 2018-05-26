package com.wjcx.link;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.Country;
import com.wjcx.bean.Minister;
import com.wjcx.utils.HbnUtil;

//���Լ���ɾ��
/**
 * Hibernate �Լ���ɾ����֧��:
 * delete--��ɾ����ǰ����ʱ,������ɾ�����й����Ķ���;
 * delete-orphan --ɾ�����к͵�ǰ������������ϵ�Ķ���;
 * all-delete-orphan --����all��delete-orphan������������Ϊ
 * */
public class LinkDeleteTest {
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
	public void testLinkDelete1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//cascade="delete/all"
	@Test
	public void testLinkDelete2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Country country=session.get(Country.class, 1);
			System.out.println(country);
			session.delete(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	//cascade="delete-orphan"
	@Test
	public void testLinkDelete3(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//��ѯcountry����
			Country country=session.get(Country.class, 3);
			Minister minister = session.get(Minister.class, 5);
			country.getMinisters().remove(minister);
			System.out.println(country);
			//��ѯcountry������minister����
//			Set<Minister> ministers=country.getMinisters();
//			Iterator<Minister> itr=ministers.iterator();
//			while(itr.hasNext()){
//				System.out.println(itr.next());
//			}
			//��ѯ��Ҫ��Ϊorphan��minister
//			Minister minister=session.get(Minister.class, 2);
//			System.out.println(minister);
//			//��minister��country�ļ�����ɾ��������Ϊ��orphan
//			//��ʱ��Country.hbm.xml��<set/>��������delete-orphan����
//			//��Ὣ��minister��DB��ɾ��
//			ministers.remove(minister);
//			//session.delete(country);
			transaction.commit();
		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			transaction.rollback();
		}
		
	}
}
