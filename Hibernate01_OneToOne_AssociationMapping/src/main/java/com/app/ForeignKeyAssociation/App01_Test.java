package com.app.ForeignKeyAssociation;

import org.hibernate.Session;

import com.app.entity.HibernateUtil;

public class App01_Test {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Create new Student object
		Student student = new Student();
			student.setFirstName("Mukesh");
			student.setLastName("kumar");
			student.setEmail("mukesh123@gmail.com");
			student.setPhone("8939651567");
			
		// Create new StudentAddress object
		StudentAddress str = new StudentAddress("dattawadi", "pune", "maharashtra", "india");
		str.setAddress("dattawadi");
		str.setCity("pune");
		str.setState("maharashtra");
		str.setCountry("india");
		student.setStudentAddress(str);
		session.save(str);
		session.save(student);
		
		 //second object
		// Create new Student object
				Student student1 = new Student();
					student1.setFirstName("Kunal");
					student1.setLastName("sagar");
					student1.setEmail("sagr123@gmail.com");
					student1.setPhone("8055969426");
					
				// Create new StudentAddress object
				StudentAddress str1 = new StudentAddress();
				str1.setAddress("satara");
				str1.setCity("satara");
				str1.setState("maharashtra");
				str1.setCountry("india");
				student1.setStudentAddress(str1);
				session.save(str1);
				session.save(student1);
				
		 

		session.getTransaction().commit();
		session.close();
	}
}
