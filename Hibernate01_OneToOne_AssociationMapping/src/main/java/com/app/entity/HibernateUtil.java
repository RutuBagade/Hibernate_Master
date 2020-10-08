package com.app.entity;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.app.ForeignKeyAssociation.Student;
import com.app.ForeignKeyAssociation.StudentAddress;
import com.app.joinedTable.AddressPK;
import com.app.joinedTable.EmployeePk;
import com.app.primaryKeyShared.Instructor;
import com.app.primaryKeyShared.InstructorDetail;





public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatetutos?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				
				// set all the properties to configuration
				configuration.setProperties(settings);
				
				
				// mapping of resource or pojo class 
				//oneTo One Mapping--Foreign Key Association
				/*
				 * configuration.addAnnotatedClass(Student.class);
				 * configuration.addAnnotatedClass(StudentAddress.class);
				 */
				//oneTo One Mapping--Joinedtable  Association
				/*
				 * configuration.addAnnotatedClass(EmployeePk.class);
				 * configuration.addAnnotatedClass(AddressPK.class);
				 */
				//one to one mapping -------Primarykeyshared
				configuration.addAnnotatedClass(Instructor.class);
				 configuration.addAnnotatedClass(InstructorDetail.class);
				 
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}