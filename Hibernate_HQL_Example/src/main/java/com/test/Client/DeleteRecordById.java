package com.test.Client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.Entities.EmployeeInfo;
import com.test.Util.HibernateUtil;

public class DeleteRecordById {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		int employeeId=1;
		
		Query query = session.createQuery("Delete EmployeeInfo where employeeId = :id ");
		query.setParameter("id", 2);
		
		int executeUpdate = query.executeUpdate();
		session.getTransaction().commit();
		if(executeUpdate>0)
			System.out.println("Employee is deleted..");
		
		
		session.close();
		
		
	}

}
