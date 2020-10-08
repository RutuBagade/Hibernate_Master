package com.demo.Test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.Util.HibernateUtil;
import com.demo.entities.Employee;

public class AppSelectTest {

	public static void main(String[] args) {
		Transaction tx=null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		  {
			  List<Employee> employees = session.createQuery("FROM Employee ").list(); 
			  for (Iterator iterator1 = employees.iterator();
					  iterator1.hasNext();){
		            Employee employee = (Employee) iterator1.next(); 
		            System.out.println("First Name: " + employee.getFirstName()); 
		            System.out.println("  Last Name: " + employee.getLastName()); 
		            System.out.println("  Salary: " + employee.getSalary());
		            List<String> certificates= employee.getCertificates();
		            certificates.forEach(m -> System.out.println(m));
		  }}
		  catch (Exception e) {
				if(tx!=null && tx.getStatus().canRollback()) {
					tx.rollback();
				}
				e.printStackTrace();
			}  
}}
