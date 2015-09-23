package com.utility.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.model.City;

public class QueryUtil {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query= session.createQuery("from City where cityId > ?");
		/*query.setFirstResult(1);
		query.setMaxResults(5);*/
		query.setInteger(0, 5);
		List<City> cities= query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(City city: cities){			
		System.out.println("City is : "+city.getCityName());
		}
		

	}

}
