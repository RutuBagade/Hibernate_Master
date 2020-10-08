package com.app.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Student;
import com.app.utils.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
	try(Session session=HibernateUtil.getSessionFactory().openSession())
	{
		tx=session.beginTransaction();
		Student student=new Student();
		student.setStudentId(1011);
		student.setStudentName("Mohan");
		student.setStudentSal(22.2);
		student.setPrjs("p1");
		student.setDept("computer");
		session.save(student);
		
		Student student1=new Student();
		student1.setStudentId(2011);
		student1.setStudentName("SHyam");
		student1.setStudentSal(27.2);
		student1.setPrjs("p3");
		student1.setDept("InformationTechnology");
		session.save(student1);
		
		Student student11=new Student();
		student11.setStudentId(3011);
		student11.setStudentName("Ashish");
		student11.setStudentSal(32.2);
		student11.setPrjs("p4");
		student11.setDept("Mechanical");
		session.save(student11);
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
