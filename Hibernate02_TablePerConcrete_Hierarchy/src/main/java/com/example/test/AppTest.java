package com.example.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Employee;
import com.example.entity.Person;
import com.example.entity.Student;
import com.example.utils.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {
		Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	Person p=new Person();
        	p.setPerId(104);
        	p.setPerName("Ramjatan");
        	
        	Employee emp=new Employee();
        	emp.setPerId(202);
        	emp.setPerName("Mohan");
        	emp.setEmpSal(5000);
        	emp.setEmpProj("P1");
        	
        	Student st=new Student();
        	st.setPerId(308);
        	st.setPerName("Sudhir kumar");
        	st.setStdFee(6000);
        	st.setGrade("A+");
        	transaction=session.beginTransaction();
        	//save all entities
        	session.save(p);
        	session.save(emp);
        	session.save(st);
        	
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
