package com.utility.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.model.City;
import com.demo.model.Tier1City;
import com.demo.model.Tier2City;

public class CityInheritanceUtil {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		City city = new City();
		city.setCityId(1);
		city.setCityName("Mumbai");
		
		Tier1City tier1City = new Tier1City();
		tier1City.setCityId(2);
		tier1City.setCityName("Delhi");
		tier1City.setMall("DelhiMall");
		
		
		Tier2City tier2City = new Tier2City();
		tier2City.setCityId(3);
		tier2City.setCityName("Nagpur");
		tier2City.setShops("Nagpur Shops");
		
		
		session.save(city);
		session.save(tier1City);
		session.save(tier2City);
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
