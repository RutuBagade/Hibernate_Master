package com.test.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.test.ForeignkeyUnidirectionalAssociation.Answer;
import com.test.ForeignkeyUnidirectionalAssociation.Question;
import com.test.foreignKeyBidirectionalAssociation.Customer;
import com.test.foreignKeyBidirectionalAssociation.Vendor;

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
				/*
				 * //one to many-----ForeignKeyUnidirecional
				 * 
				 * configuration.addAnnotatedClass(Vendor.class);
				 * configuration.addAnnotatedClass(Customer.class);
				 */
				//one to many-----ForeignkeyBidirectional
				
				  configuration.addAnnotatedClass(Question.class);
				     configuration.addAnnotatedClass(Answer.class);
				 
				//one to many-----JoinedTable
				/*
				  configuration.addAnnotatedClass(Cart1.class);
				  configuration.addAnnotatedClass(Items1.class);
				 */
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