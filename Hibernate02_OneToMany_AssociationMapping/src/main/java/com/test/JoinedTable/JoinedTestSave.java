package com.test.JoinedTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.test.Util.HibernateUtil;

public class JoinedTestSave {

	public static void main(String[] args) {
		Transaction tx=null;
		  try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            
			  Cart1 cart = new Cart1();
				cart.setName("MyCart1");
				
				Items1 item1 = new Items1("I10", 10, 1);
				Items1 item2 = new Items1("I20", 20, 2);
				
				Set<Items1> itemsSet = new HashSet<Items1>();
				itemsSet.add(item1); 
				itemsSet.add(item2);
				
				cart.setItems1(itemsSet);
				cart.setTotal(10*1 + 20*2);
				tx= session.beginTransaction();
				session.save(cart);
			
				
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}