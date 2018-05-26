package com.wjcx.hb.bean;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wjcx.hb.bean.Student;

public class StudentTest {

	@Test
	public void testInsert() {
		//加载配置文件
		Configuration configure=new Configuration().configure();
		//创建sessionFactory
		SessionFactory sessionFactory=configure.buildSessionFactory();
		//获取session
		Session session=sessionFactory.openSession();
		//开启事务
		Transaction transaction=session.beginTransaction();
		//数据库操作
		Student student=new Student();
		student.setStuname("Kazaf");
		student.setScore(80.0);
		student.setAge(23);
		
		//保存
		session.save(student);
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
	}

}
