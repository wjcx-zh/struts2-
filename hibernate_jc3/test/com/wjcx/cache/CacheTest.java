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
		 * 测试自动建表,对应数据库的方言要选对，否则会报错，无法建表。
		 * 对于mysql5之后的版本，方言应选MySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	
	//测试快照
	@Test
	public void testCache2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//执行查询，会将结果保存于session缓存,并在快照中保存一个副本
			Student stu=session.get(Student.class, 1);
			System.out.println(stu);
			//修改数据
			stu.setScore(87.88);
			System.out.println(stu);
			//提交时会与快照数据对比,数据不同,执行update,并同时在快照中保存一份副本.
			//transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	
}
