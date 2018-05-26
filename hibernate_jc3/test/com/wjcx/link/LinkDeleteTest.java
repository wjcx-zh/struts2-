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

//测试级联删除
/**
 * Hibernate 对级联删除的支持:
 * delete--当删除当前对象时,将级联删除所有关联的对象;
 * delete-orphan --删除所有和当前对象解除关联关系的对象;
 * all-delete-orphan --包含all和delete-orphan级联的所有行为
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
		 * 测试自动建表,对应数据库的方言要选对，否则会报错，无法建表。
		 * 对于mysql5之后的版本，方言应选MySQL5InnoDBDialect
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
			//查询country对象
			Country country=session.get(Country.class, 3);
			Minister minister = session.get(Minister.class, 5);
			country.getMinisters().remove(minister);
			System.out.println(country);
			//查询country的所有minister对象
//			Set<Minister> ministers=country.getMinisters();
//			Iterator<Minister> itr=ministers.iterator();
//			while(itr.hasNext()){
//				System.out.println(itr.next());
//			}
			//查询将要变为orphan的minister
//			Minister minister=session.get(Minister.class, 2);
//			System.out.println(minister);
//			//将minister从country的集合中删除，即变为了orphan
//			//此时若Country.hbm.xml的<set/>中设置了delete-orphan级联
//			//则会将此minister从DB中删除
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
