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
		//1.加载主配置文件和映射文件
		Configuration configure=new Configuration().configure();
		//2.创建SessionFactory对象
		SessionFactory sessionFactory=configure.buildSessionFactory();
		//3.开启Session对象
		Session session=sessionFactory.openSession();
		try {
			//4.开启事务
			Transaction transaction=session.beginTransaction();
			Student student=new Student();
			student.setName("Kazaf");
			student.setAge(23);
			student.setScore(78.9);
			//5.执行操作
			session.save(student);
			//6.提交事务
			transaction.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//回滚事务
			session.getTransaction().rollback();
			session.close();
		}
	}
}
