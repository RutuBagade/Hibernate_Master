package com.app.primaryKeyShared;

import org.hibernate.Session;


import com.app.entity.HibernateUtil;

public class App03 {
public static void main(String[] args) {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
	
    Instructor instructor = new Instructor("Sagar", "Khole", "sagr234@java123.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
    instructor.setInstructorDetail(instructorDetail);

    session.save(instructor);
    
    session.getTransaction().commit();
    session.close();
	
}
}
