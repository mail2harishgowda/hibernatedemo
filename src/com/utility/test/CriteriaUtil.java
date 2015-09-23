package com.utility.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.demo.model.City;

public class CriteriaUtil {
	
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(City.class);
		//criteria.add(Restrictions.gt("cityId", 4)).add(Restrictions.le("cityId", 6));
		//criteria.add(Restrictions.like("cityName", "%1%"));
		//criteria.add(Restrictions.between("cityId", 3,6));
		
		/*LogicalExpression orexpression =Restrictions.or(Restrictions.like("cityName", "%1%"),
				Restrictions.like("cityName", "%2%"));*/
		criteria.setProjection(Projections.sum("cityId"));
		

		List<City>cities= criteria.list();
		
	 /* for(City city: cities){
			System.out.println("City is: "+city.getCityName());
		}*/
		
		System.out.println("City count: "+cities.get(0));

		
		session.getTransaction().commit();
		session.close();
		
	}
	

}

