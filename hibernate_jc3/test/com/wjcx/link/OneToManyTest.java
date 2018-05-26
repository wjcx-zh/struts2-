package com.wjcx.link;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.Country;
import com.wjcx.bean.Minister;
import com.wjcx.utils.HbnUtil;

public class OneToManyTest {
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
	public void testOneToMany1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//�������������һ��ʵ����û�й������set,ӳ���Ҳû��ӳ��
	/**
	 * ά������һ�������ü���Ϊupdate-save��
	 * ��save country ��ʱ����һ����minister��ӽ����ݱ�
	 * 
	 * */
	@Test
	public void testOneToMany2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("Z");
			Minister minis2=new Minister();
			minis2.setMname("X");
			minis.add(minis1);
			minis.add(minis2);
			Country country=new Country();
			country.setCname("CHI");
			country.setMinisters(minis);
			
			session.save(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	/**
	 * ά������һ���������ü�����
	 * ��save country ��ʱ������save Minister
	 * ����һ��updateԤ������䣬��DB�ж�Ӧministerû������
	 * ����������ӻ�ʧ�ܣ����� object references an unsaved transient instance
	 * 		
	 * */
	@Test
	public void testOneToMany3(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("C");
			Minister minis2=new Minister();
			minis2.setMname("B");
			minis.add(minis1);
			minis.add(minis2);
			Country country=new Country();
			country.setCname("USA");
			country.setMinisters(minis);
			
			session.save(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	
	/**
	 * ά������һ�������ü���save-update��һ������ά����
	 * ��save country ��ʱ��save Minister
	 * 
	 * ������һ��updateԤ������䣬DB�ж�Ӧminister�����û������
	 * ������ӳɹ�
	 * 		
	 * */
	@Test
	public void testOneToMany4(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("C");
			Minister minis2=new Minister();
			minis2.setMname("B");
			minis.add(minis1);
			minis.add(minis2);
			Country country=new Country();
			country.setCname("Japan");
			country.setMinisters(minis);
			
			session.save(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	//˫�����
	@Test
	public void testOneToMany5(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("C");
			Minister minis2=new Minister();
			minis2.setMname("B");
			minis.add(minis1);
			minis.add(minis2);
			Country country=new Country();
			country.setCname("Australia");
			country.setMinisters(minis);
			minis1.setCountry(country);
			minis2.setCountry(country);
			session.save(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	//���ｫ�෽ά��ȥ��
	@Test
	public void testOneToMany6(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("C");
			Minister minis2=new Minister();
			minis2.setMname("B");
			minis.add(minis1);
			minis.add(minis2);
			Country country=new Country();
			country.setCname("CHINESE");
			country.setMinisters(minis);
			minis1.setCountry(country);
			minis2.setCountry(country);
			session.save(country);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	
	
	@Test
	public void testOneToMany7(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			Set<Minister> minis=new HashSet<Minister>();
			Minister minis1=new Minister();
			minis1.setMname("Z");
			minis.add(minis1);
			Country country=new Country();
			country.setCname("Italy");
			country.setMinisters(minis);
			minis1.setCountry(country);
			session.save(minis1);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
}
