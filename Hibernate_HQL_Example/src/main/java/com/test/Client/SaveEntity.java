package com.test.Client;


import com.test.Entities.EmployeeInfo;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class SaveEntity {
	public static void main(String[] args) {
		SessionFactory sf = com.test.Util.HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
		session.beginTransaction();
		
		EmployeeInfo employee1 = new EmployeeInfo();
		employee1.setEmployeeName("Kunal bagade");
		employee1.setDesignation("Autocad Engineer");
		employee1.setDoj(new Date());
		employee1.setEmail("K8055969426@gmail.com");
		employee1.setBonus(new BigDecimal(2000));
		employee1.setSalary(25000.00);
		
		EmployeeInfo employee2 = new EmployeeInfo();
		employee2.setEmployeeName("Tushar Mundaravle");
		employee2.setDesignation("Plc  Engineer");
		employee2.setDoj(new Date());
		employee2.setEmail("tum26594@gmail.com");
		employee2.setBonus(new BigDecimal(2500));
		employee2.setSalary(40000.00);
		
		session.save(employee1);
		session.save(employee2);
		
		session.getTransaction().commit();
		session.close();
	
}
		
	}


