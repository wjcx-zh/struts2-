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
		 * 测试自动建表,对应数据库的方言要选对，否则会报错，无法建表。
		 * 对于mysql5之后的版本，方言应选MySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//单向关联，其中一个实体类没有关联类的set,映射表也没有映射
	/**
	 * 维护方在一方，设置级联为update-save。
	 * 在save country 的时，会一并将minister添加进数据表。
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
	 * 维护方在一方，不设置级联。
	 * 在save country 的时，不做save Minister
	 * 产生一条update预处理语句，但DB中对应minister没有数据
	 * 所以数据添加会失败，报错： object references an unsaved transient instance
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
	 * 维护方在一方，设置级联save-update，一方放弃维护。
	 * 在save country 的时，save Minister
	 * 
	 * 不产生一条update预处理语句，DB中对应minister的外键没有数据
	 * 数据添加成功
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
	
	//双相关联
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
	
	//这里将多方维护去除
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
