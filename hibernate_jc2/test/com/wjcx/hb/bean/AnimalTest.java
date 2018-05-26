package com.wjcx.hb.bean;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.hb.util.SessionUtil;

public class AnimalTest {
	private Session session;
	private Transaction transaction;
	@Before
	public void before(){
		session=SessionUtil.getSession();
		transaction=session.beginTransaction();
	}
	
	@After
	public void after(){
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
	}
	
	@Test
	public void testAnimal1() {
		Animal animal=session.get(Animal.class, "297e4d2c624c764e01624c76507e0000");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		animal.setName("bsscat");
		//animal.setAge(3);
		session.evict(animal);
		
		session.update(animal);
		
	}
	
	@Test
	public void testAnimal2() {
		Animal animal=session.get(Animal.class, "297e4d2c624c764e01624c76507e0000");
		//animal.setName("big_cat");
		session.evict(animal);
		animal.setAge(2);
		session.update(animal);
	}

}
