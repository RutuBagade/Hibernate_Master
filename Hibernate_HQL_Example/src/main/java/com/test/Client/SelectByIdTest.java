package com.test.Client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.Entities.EmployeeInfo;
import com.test.Util.HibernateUtil;

public class SelectByIdTest {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		int employeeId=1;
		/*String HQL = "FROM EmployeeInfo WHERE employeeId=?";
		Query query=session.createQuery(HQL);
		query.setParameter(0, employeeId);*/
		Query query = session.createQuery("from EmployeeInfo where employeeId = :id ");
		query.setParameter("id", 1);
		List<EmployeeInfo> list=query.list();
		for(EmployeeInfo emp:list)
		{
			System.out.println(emp);
		}
		session.getTransaction().commit();
		session.close();
		
		
	}

}
