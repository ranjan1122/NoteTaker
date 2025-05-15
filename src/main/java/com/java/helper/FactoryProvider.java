package com.java.helper;
  
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	public static SessionFactory factory;
	public static SessionFactory returnSsnFactory() {
		if(factory==null) {
			Configuration conf=new Configuration().configure("hibernate.cfg.xml");
			factory=conf.buildSessionFactory();
		}
		
		return factory;
	}

	public void closeSessionFactory() {
		if(factory.isOpen()) {
			factory.close();
			
		}
	}
}
