package com.utility.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.model.City;

public class CacheUtil {

	public static void main(String[] args) {
			
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		City city = session.get(City.class, 1);	

		
		session.getTransaction().commit();
		session.close();
		
		
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		City city2 = session2.get(City.class, 1);
		City city3 = session2.get(City.class, 1);
		City city4 = session2.get(City.class, 1);
		

		
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
