package com.test.foreignKeyBidirectionalAssociation;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.Util.HibernateUtil;

public class App01_Testsave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()){
			  
			  Customer c1= new Customer();
			  c1.setCname("Shikha");
			  Customer c2= new Customer();
			  c2.setCname("shubham");
			  Customer c3= new Customer();
			  c3.setCname("kunal");
			  Customer c4= new Customer();
			  c4.setCname("Rutuja");
			  Customer c5= new Customer();
			  c5.setCname("nita");
			  //Add new vendor object
			  Vendor vendor= new Vendor();
			  vendor.setName("jyotika");
			  
			  Vendor vendor1= new Vendor();
			  vendor1.setName("Sunrise");
			  
			  Set<Customer> s1=new HashSet<Customer>();
			  s1.add(c1);
			  s1.add(c2);
			 s1.add(c3);
			  Set<Customer> s2=new HashSet<Customer>();
			  s2.add(c4);
			  s2.add(c5);
			 
			  
			  vendor.setChildren(s1);
			  vendor1.setChildren(s2);
			  tx= session.beginTransaction();
			  session.save(vendor);
		        session.save(vendor1);
		 
		        session.getTransaction().commit();
		}
		  catch (Exception e) {
				if(tx!=null && tx.getStatus().canRollback()) 
					tx.rollback();
				
				e.printStackTrace();
			}
	}

}
