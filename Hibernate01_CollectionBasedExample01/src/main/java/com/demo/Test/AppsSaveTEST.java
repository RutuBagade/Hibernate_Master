package com.demo.Test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.Util.HibernateUtil;
import com.demo.entities.Employee;

public class AppsSaveTEST {
	public static void main(String[] args) {
		Transaction tx=null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			  Employee emp=new Employee();
			  emp.setId(301);
			  emp.setFirstName("FirstUser1");
			  emp.setLastName("Lastuser1");
			  emp.setSalary(15000);
			  emp.getCertificates().add("B.E");
			  emp.getCertificates().add("MBA");
			  emp.getCertificates().add("MCA");
			  tx= session.beginTransaction();
			  
			  session.save(emp);
			  Employee emp1=new Employee();
			  emp1.setId(401);
			  emp1.setFirstName("FirstUser2");
			  emp1.setLastName("Lastuser2");
			  emp1.setSalary(25000);
			  emp1.getCertificates().add("MPhram");
			  emp1.getCertificates().add("BPharm");
			  emp1.getCertificates().add("Diploma");
			Serializable id= session.save(emp1);
			System.out.println(id);
			  tx.commit();
			  
		  }catch (Exception e) {
				if(tx!=null && tx.getStatus().canRollback()) {
					tx.rollback();
				}
				e.printStackTrace();
			}  
		
	}

}
