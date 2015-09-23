package com.utility.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.UserDetails;
import com.demo.model.Vehicle;

public class HibernateUtility {
	
	public static void main(String[] args) {
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setPincode("410209");
		address.setState("Maharashtra");
		address.setStreet("Street");
		
		Vehicle vehicle =  new Vehicle();
		vehicle.setName("Car");
		
		Vehicle vehicle2 =  new Vehicle();
		vehicle2.setName("Jeep");
		
		UserDetails userDetails1  = new UserDetails();
		userDetails1.setUserName("Harish");
		userDetails1.setJoinDate(new Date());
		userDetails1.setDescription("This is huge description of text");
		userDetails1.getVehicles().add(vehicle);
		
		vehicle.getUserDetails().add(userDetails1);
		
		

		UserDetails userDetails2  = new UserDetails();
		userDetails2.setUserName("sachin");
		userDetails2.setJoinDate(new Date());
		userDetails2.setDescription("This is second huge description of text");
		userDetails2.getVehicles().add(vehicle2);
		
		vehicle2.getUserDetails().add(userDetails2);


	

		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(userDetails1);
		session.save(userDetails2);
		
		session.save(vehicle);
		session.save(vehicle2);
		
		
		userDetails1.setUserName("User Updated");
		userDetails1.setUserName("User 																																				");
		


		session.getTransaction().commit();
		UserDetails user2= session.get(UserDetails.class, 1);

		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user= session.get(UserDetails.class, 1);

		session.close();
		
		
		
		
		

		
	}

}
