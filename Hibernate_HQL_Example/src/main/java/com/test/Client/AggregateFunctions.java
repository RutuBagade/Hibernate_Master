package com.test.Client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AggregateFunctions {
	public static void main(String[] args) {
		SessionFactory sf = com.test.Util.HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		/*Query q=session.createQuery("select sum(salary) from EmployeeInfo");  
		List<Integer> list=q.list();  
		System.out.println("Sum Of salaries :"+list.get(0));  
		//Sum Of salaries :353000.0
		Query q1=session.createQuery("select MIN(salary) from EmployeeInfo");  
		List<Integer> list1=q1.list();  
		System.out.println("MIN Of salaries :"+list1.get(0)); */ 
		/*Query q=session.createQuery("select MAX(salary) from EmployeeInfo");  
		List<Integer> list=q.list();  
		System.out.println("Max Of salaries :"+list.get(0)); */
		
		String HQL="SELECT COUNT(e),AVG(e.salary),MIN(e.salary),SUM(e.salary),MAX(e.salary) FROM EmployeeInfo e";
		
		Query query = session.createQuery(HQL);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			Long empCount=(Long)objects[0];
			Double avgSal=(Double)objects[1];
			Double minSal=(Double)objects[2];
			Double sumOfSal=(Double)objects[3];
			Double maxSal=(Double)objects[4];
			System.out.println("Total no. of Employees:"+empCount);
			System.out.println("Avg salary:"+avgSal);
			System.out.println("Min Salary:"+minSal);
			System.out.println("Sum of Salary:"+sumOfSal);
			System.out.println("max Salary:"+maxSal);
		}
		session.getTransaction().commit();
		session.close();
	
		
	}
}
