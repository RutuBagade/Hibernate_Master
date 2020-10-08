package com.test.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.Entities.Customer;
import com.test.utils.HibernateUtil;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
		
			List<Customer> cust=session.createQuery("from Customer ").list();
			
			Iterator itr=cust.iterator();
					while(itr.hasNext())
			{
				Customer cust1=(Customer) itr.next();
				 System.out.println("customer ID: " + cust1.getCustId()); 
		            System.out.println("  Customer Name: " + cust1.getCustName()); 
		            System.out.println("Customer data :");
		            Set<String> customer=cust1.getCustData();
		            customer.forEach(custom -> System.out.println(custom));
		            
		            System.out.println("customer Mapdata :");
		            Map<Integer,String> map=cust1.getData();
		           for(Entry<Integer, String> entry: map.entrySet() )
		           {
		        	   System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue()); 
		         }
		          
		           }
			 
		}
		catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}  

	}

}
