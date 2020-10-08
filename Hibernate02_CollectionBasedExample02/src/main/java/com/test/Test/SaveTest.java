package com.test.Test;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.test.Entities.Customer;
import com.test.utils.HibernateUtil;

public class SaveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			tx=session.beginTransaction();
			Customer c=new Customer();
			c.setCustId(1001);
			c.setCustName("mohan");
			c.getCustData().add("D1");
			c.getCustData().add("D2");
			c.getData().put(10, "M1");
			c.getData().put(11, "M2");
			session.save(c);
			Customer c1=new Customer();
			c1.setCustId(2001);
			c1.setCustName("Soham");
			c1.getCustData().add("D3");
			c1.getCustData().add("D4");
			c1.getData().put(10, "M3");
			c1.getData().put(11, "M4");
			session.save(c1);
			Customer c11=new Customer();
			c11.setCustId(3001);
			c11.setCustName("komal");
			c11.getCustData().add("D5");
			c11.getCustData().add("D6");
			c11.getData().put(10, "M5");
			c11.getData().put(11, "M6");
			session.save(c11);
			tx.commit();

			
		}
		catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}  
	
		

	}

}
