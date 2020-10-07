package com.test.Client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.Entities.EmployeeInfo;
import com.test.Util.HibernateUtil;

public class SelectAllRecord 
{
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from EmployeeInfo");
		query.setFirstResult(2);//skip first 3 rows and get results from onwards
		query.setMaxResults(5);//retrieve only first  results depends on integer value
		List<EmployeeInfo> emp=query.list();
		for(EmployeeInfo list:emp)
		{
			System.out.println(list);
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
