package com.example.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Contract_Employee;
import com.example.entity.Employee;

import com.example.entity.Regular_Employee;
import com.example.utils.HibernateUtil;

/*in case of table per subclass strategy, tables are created as per persistent classes 
but they are treated using primary and foreign key. So there will not be any duplicate column in the relation.

We need to specify @Inheritance(strategy=InheritanceType.JOINED) 
in the parent class and @PrimaryKeyJoinColumn annotation in the subclasses.*/
public class AppTest {

	public static void main(String[] args) {
		Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	Employee e1=new Employee();    
            e1.setName("Gaurav Chawla");    
                
            Regular_Employee e2=new Regular_Employee();    
            e2.setName("Vivek Kumar");    
            e2.setSalary(50000);    
            e2.setBonus(5);    
                
            Contract_Employee e3=new Contract_Employee();    
            e3.setName("Arjun Kumar");    
            e3.setPay_per_hour(1000);    
            e3.setContract_duration("15 hours");    
        	transaction=session.beginTransaction();
        	//save all entities
        	session.save(e1);
        	session.save(e2);
        	session.save(e3);
        	
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        

	}

}
