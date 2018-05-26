package hibernate_jc3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.wjcx.bean.Student;

public class TestCommon {
	@Test
	public void test1(){
		//1.�����������ļ���ӳ���ļ�
		Configuration configure=new Configuration().configure();
		//2.����SessionFactory����
		SessionFactory sessionFactory=configure.buildSessionFactory();
		//3.����Session����
		Session session=sessionFactory.openSession();
		try {
			//4.��������
			Transaction transaction=session.beginTransaction();
			Student student=new Student();
			student.setName("Kazaf");
			student.setAge(23);
			student.setScore(78.9);
			//5.ִ�в���
			session.save(student);
			//6.�ύ����
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�ع�����
			session.getTransaction().rollback();
			session.close();
		}
	}
}
