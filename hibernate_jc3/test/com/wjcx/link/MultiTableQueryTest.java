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

//������Ӳ�ѯ����
/**
 * �ѿ������� select * from R,S
 * ��������֮��ֵ���ӣ�select * from R,S where C=E
 * ������(ͬ ��ֵ):select * from R [inner] join S on C=E
 * ��������:select * from R left [outer] join S on R.B=S.B
 * ��������:select * from R right [outer] join S on R.B=S.B
 * hibernate �������� ��Ӧ����fetch
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
		 * �����Զ�����,��Ӧ���ݿ�ķ���Ҫѡ�ԣ�����ᱨ���޷�����
		 * ����mysql5֮��İ汾������ӦѡMySQL5InnoDBDialect
		 * */
		System.out.println(session);
	}
	
	//left join
	@Test
	public void testQuery2(){
		Transaction transaction=session.getTransaction();
		
		try {
			transaction.begin();
			//�������ӵĶ���Ϊcountry��minister����
			String hql="from Country c left join c.ministers";
			//�������ӵĲ�ѯ���ΪList,�䷺��ΪObject[]
			//����ĵ�һ��Ԫ��Ϊ��ѯ����Country����,���Ѿ���װΪ��Country����
			//����ĵڶ���Ԫ��Ϊ��ѯ����Minister����,���Ѿ���װΪ��Minister����
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
			//�����������ӵĶ���Ϊcountry��minister����
			String hql="from Country c left join fetch c.ministers";
			//�����������ӵĲ�ѯ���ΪList,�䷺��ΪCountry
			//���ҽ���ѯ����Minister����Ҳ��װ������Ӧ��Country��
			//���������������ӽ�֮�������ӣ�ʵ�������ݵ��Զ���װ
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
			//�����������ӵĶ���Ϊcountry��minister����
			String hql="select distinct c from Country c left join fetch c.ministers";
			//�����������ӵĲ�ѯ���ΪList,�䷺��ΪCountry
			//���ҽ���ѯ����Minister����Ҳ��װ������Ӧ��Country��
			//���������������ӽ�֮�������ӣ�ʵ�������ݵ��Զ���װ
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
