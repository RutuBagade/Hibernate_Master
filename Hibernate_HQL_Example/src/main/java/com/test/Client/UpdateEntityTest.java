package com.test.Client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.Entities.EmployeeInfo;
import com.test.Util.HibernateUtil;

public class UpdateEntityTest 
{
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		String HQL = "UPDATE EmployeeInfo set email=:newEmail WHERE employeeId=:empId";
		
		Query query = session.createQuery(HQL);
		query.setParameter("newEmail", "kumvatkomal85@gmail.com");
		query.setParameter("empId", 5);
		
	
		int executeUpdate = query.executeUpdate();
		
		if(executeUpdate>0)
			System.out.println("Employee email is updated..");
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
