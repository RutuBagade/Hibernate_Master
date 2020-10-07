package com.app.joinedTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.entity.HibernateUtil;



public class App02 
{
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		EmployeePk e1=new EmployeePk();    
        e1.setName("Ravi Malik");    
        e1.setEmail("ravi@gmail.com");    
            
        AddressPK address1=new AddressPK();    
        address1.setAddressLine1("G-21,Lohia nagar");    
        address1.setCity("Ghaziabad");    
        address1.setState("UP");    
        address1.setCountry("India");    
        address1.setPincode(201301); 
        
        e1.setAddress(address1); 
        
        address1.setEmployee(e1);    
       session.save(e1); 
       
		
		session.getTransaction().commit();
		session.close();
	
    }
}
