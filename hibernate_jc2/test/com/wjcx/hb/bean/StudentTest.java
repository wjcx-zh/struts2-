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
		//���������ļ�
		Configuration configure=new Configuration().configure();
		//����sessionFactory
		SessionFactory sessionFactory=configure.buildSessionFactory();
		//��ȡsession
		Session session=sessionFactory.openSession();
		//��������
		Transaction transaction=session.beginTransaction();
		//���ݿ����
		Student student=new Student();
		student.setStuname("Kazaf");
		student.setScore(80.0);
		student.setAge(23);
		
		//����
		session.save(student);
		//�ύ����
		transaction.commit();
		//�ͷ���Դ
		session.close();
	}

}
