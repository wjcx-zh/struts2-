package com.wjcx.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtil {
	private static SessionFactory sessionFactory;
	
	public static Session getSession(){
		return getSessionFactory().openSession();
	}

	private static SessionFactory getSessionFactory() {
		if(sessionFactory==null||sessionFactory.isClosed()){
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
