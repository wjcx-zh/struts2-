package com.wjcx.hb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static Configuration configure;
	private static SessionFactory sessionFactory;
	static{
		configure=new Configuration().configure(); 
		sessionFactory=configure.buildSessionFactory();
	}
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
