package com.utility.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.model.City;

public class CityAddUtil {
	
	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		   for( int i=1;i<=10;i++){
			   City city = new City();
			   city.setCityName("City "+i);
			   session.save(city);
			}
		
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
