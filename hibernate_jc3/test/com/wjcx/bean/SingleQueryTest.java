package com.wjcx.bean;



import java.util.Iterator;
import java.util.List;

import org.apache.catalina.tribes.util.Arrays;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wjcx.utils.HbnUtil;
/**
 * 测试单表查询
 * */
@SuppressWarnings("all")
public class SingleQueryTest {
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
	public void testDatas(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			for(int i=0;i<15;i++){
				Student stu=new Student();
				stu.setAge(15+i);
				stu.setName("Hasade_"+i);
				stu.setScore(75+i);
				session.save(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//查询所有,返回list集合--sql
	@Test 
	public void testSelectAll1(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String sql="select * from t_student";
			List<Student> stus=session.createSQLQuery(sql)
								.addEntity(Student.class).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//查询所有,返回list集合--hql
	@Test 
	public void testSelectAll2(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student";
			List<Student> stus=session.createQuery(hql).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//查询所有,返回list集合--qbc
	@Test 
	public void testSelectAll3(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			List<Student> stus=session.createCriteria(Student.class).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//查询结果排序,order by 
	//--hql
	@Test 
	public void testSelectAllOrder1(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student order by score desc";
			List<Student> stus=session.createQuery(hql).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//查询结果排序,order by 
	//--qbc
	@Test 
	public void testSelectAllOrder2(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			List<Student> stus=session.createCriteria(Student.class).addOrder(Order.desc("score")).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//动态参数绑定查询,4,hql
	//--hql_1
	@Test 
	public void testSelectWithCondition_hql_1(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where sage>:age and score <:score";
			List<Student> stus=session.createQuery(hql)
							.setParameter("age", 18).setParameter("score",80.0).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	//动态参数绑定查询,4,hql
	//--hql_2
	@Test 
	public void testSelectWithCondition_hql_2(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where sage>:age and score <:score";
			List<Student> stus=session.createQuery(hql)
							.setInteger("age", 18).setDouble("score",80.0).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	//动态参数绑定查询,4,hql
	//--hql_3
	@Test 
	public void testSelectWithCondition_hql_3(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where sage>? and score <?";
			List<Student> stus=session.createQuery(hql)
							.setParameter(0, 18).setParameter(1,80.0).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	//动态参数绑定查询,4,hql
	//--hql_4
	@Test 
	public void testSelectWithCondition_hql_4(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where sage>? and score <?";
			List<Student> stus=session.createQuery(hql)
							.setInteger(0, 18).setDouble(1,80.0).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//动态参数绑定查询,qbc
	//--qbc
	@Test 
	public void testSelectWithCondition_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			List<Student> stus=session.createCriteria(Student.class)
							.add(Restrictions.gt("age", 18))
							.add(Restrictions.lt("score", 80.0)).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//分页查询
	/**
	 * 总查询结果集从0开始计数
	 * setFirstResult():开始记录;setMaxResult():该页记录数
	 * */
	@Test
	public void testPaging_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student";
			List<Student> stus=session.createQuery(hql)
							.setFirstResult(3)
							.setMaxResults(5).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//分页查询
	/**
	 * Criteria接口
	 * 总查询结果集从0开始计数
	 * setFirstResult():开始记录;setMaxResult():该页记录数
	 * */
	@Test
	public void testPaging_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			
			List<Student> stus=session.createCriteria(Student.class)
							.setFirstResult(3)
							.setMaxResults(5).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//模糊查询
	@Test
	public void testLike_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where name like :myname";
			List<Student> stus=session.createQuery(hql)
							.setParameter("myname", "%e%").list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//模糊查询
	@Test
	public void testLike_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			
			List<Student> stus=session.createCriteria(Student.class)
							.add(Restrictions.like("name", "%k%")).list();
			
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//唯一性查询
	@Test
	public void testUnique_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student where score=:myscore";
			Student stu=(Student)session.createQuery(hql)
							//.setParameter("myscore", 82.0)
							.setParameter("myscore", 85.0)
							.uniqueResult();
			
			//for(Student stu:stus){
			System.out.println(stu);
		//	}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//唯一性查询
	@Test
	public void testUnique_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			Student stu=(Student)session.createCriteria(Student.class)
							.add(Restrictions.eq("score", 85.0))
							.uniqueResult();
			
			//for(Student stu:stus){
			System.out.println(stu);
		//	}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//聚合函数查询
	//count()--hql
	@Test
	public void testCount_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="select count(*) from Student";
			long result=(Long)session.createQuery(hql).uniqueResult();
			System.out.println(result);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//count()--hql
	@Test
	public void testCount_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			long result=(Long)session.createCriteria(Student.class)
							.setProjection(Projections.count("id")).uniqueResult();
			System.out.println(result);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//max()--hql
	@Test
	public void testMax_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="select Max(score) from Student";
			double result=(Double)session.createQuery(hql).uniqueResult();
			System.out.println(result);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//投影查询
	/**
	 * HQL:
	 * 要求实体类中具有相同投影作为参数的带参构造器。
	 * */
	
	@Test
	public void testReflext_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="select new Student(name,age) from Student";
			List<Student> stus=session.createQuery(hql).list();
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	/**
	 * QBC:
	 * 要求实体类中具有相同投影作为参数的带参构造器。
	 * */
	
	@Test
	public void testReflext_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			//指定投影
			ProjectionList projections=Projections.projectionList()
									.add(Projections.alias(Projections.property("name"), "name"))
									.add(Projections.alias(Projections.property("age"), "age"));
			
			
			List<Student> stus=session.createCriteria(Student.class)
								.setProjection(projections)
								.setResultTransformer(Transformers.aliasToBean(Student.class)).list();
			for(Student stu:stus){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//分组查询
	//group by ,having--hql
	@Test
	public void testGroup_hql(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql1="select age,count(age) from Student group by age";
			List<Object[]> stus=session.createQuery(hql1).list();
			for(Object[] stu:stus){
				System.out.println(Arrays.toString(stu));
			}
			System.out.println("=========================");
			String hql2="select age,count(age),avg(age) from Student group by age having count(age)>:num";
			List<Object[]> stus2=session.createQuery(hql2).setParameter("num", 1L).list();
			for(Object[] stu:stus2){
				System.out.println(Arrays.toString(stu));
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//group by --qbc ,不直接支持having
	@Test
	public void testGroup_qbc(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			
			List<Object> stus=session.createCriteria(Student.class)
								.setProjection(Projections.groupProperty("age")).list();
			for(Object stu:stus){
				System.out.println(stu);
			}
			
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//Query :list() && iterator()
	
	//list()
	@Test 
	public void testList(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student";
			//第一次查询
			List<Student> stus=session.createQuery(hql).list();
			for(Student stu:stus){
				System.out.println(stu);
			}
			System.out.println("=========================");
			//第二次查询
			List<Student> stus2=session.createQuery(hql).list();
			for(Student stu:stus2){
				System.out.println(stu);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	
	//iterator() :使用缓存，会出现N+1问题
	@Test 
	public void testIterator(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student";
			//第一次查询
			Iterator<Student> stus=session.createQuery(hql).iterate();
			while(stus.hasNext()){
				System.out.println(stus.next());
			}
			System.out.println("=========================");
			//第二次查询
			Iterator<Student> stus2=session.createQuery(hql).iterate();
			while(stus2.hasNext()){
				System.out.println(stus2.next());
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	//iterator() :使用缓存，会出现N+1问题，问题的避免
	@Test 
	public void testIterator2(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			String hql="from Student";
			//第一次查询
			List<Student> stus=session.createQuery(hql).list();
			for(Student stu:stus){
				System.out.println(stu);
			}
			System.out.println("=========================");
			//第二次查询
			Iterator<Student> stus2=session.createQuery(hql).iterate();
			while(stus2.hasNext()){
				System.out.println(stus2.next());
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	
	//命名查询--查询语句在映射文件中的查询
	@Test 
	public void testNameQuery(){
		Transaction transaction=session.getTransaction();
		try {
			transaction.begin();
			Student stu=(Student) session.getNamedQuery("queryById")
					.setParameter("sid", 1).uniqueResult();
			System.out.println(stu);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
