package com.wjcx.link;

import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.bean.Country;
import com.wjcx.utils.HbnUtil;

//多表连接查询测试
/**
 * 笛卡尔积： select * from R,S
 * 条件连接之等值连接：select * from R,S where C=E
 * 内连接(同 等值):select * from R [inner] join S on C=E
 * 左外连接:select * from R left [outer] join S on R.B=S.B
 * 右外连接:select * from R right [outer] join S on R.B=S.B
 * hibernate 迫切链接 对应加上fetch
 * */
public class MultiTableQueryTest {
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
	public void testQuery1(){
		//Transaction transaction=session.getTransaction();
		
		//transaction.begin();
		/**
		 * 测试自动建表,对应数据库的方言要选对，否则会报错，无法建表。
		 * 对于mysql5之后的版本，方言应选MySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//left join
	@Test
	public void testQuery2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//左外连接的对象为country的minister属性
			String hql="from Country c left join c.ministers";
			//左外连接的查询结果为List,其泛型为Object[]
			//数组的第一个元素为查询出的Country数据,但已经封装为了Country对象
			//数组的第二个元素为查询出的Minister数据,但已经封装为了Minister对象
			List<Object[]> list=session.createQuery(hql).list();
			for(Object[] obj:list){
				System.out.println(Arrays.toString(obj));
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//fetch left join
	@Test
	public void testQuery3(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//迫切左外连接的对象为country的minister属性
			String hql="from Country c left join fetch c.ministers";
			//迫切左外连接的查询结果为List,其泛型为Country
			//并且将查询出的Minister对象也封装到了相应的Country中
			//所以迫切左外连接较之左外连接，实现了数据的自动封装
			List<Country> list=session.createQuery(hql).list();
			for(Country country:list){
				System.out.println(country);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//fetch left join distinct
	@Test
	public void testQuery4(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//迫切左外连接的对象为country的minister属性
			String hql="select distinct c from Country c left join fetch c.ministers";
			//迫切左外连接的查询结果为List,其泛型为Country
			//并且将查询出的Minister对象也封装到了相应的Country中
			//所以迫切左外连接较之左外连接，实现了数据的自动封装
			List<Country> list=session.createQuery(hql).list();
			for(Country country:list){
				System.out.println(country);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
