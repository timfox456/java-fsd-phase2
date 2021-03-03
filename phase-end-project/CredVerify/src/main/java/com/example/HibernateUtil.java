package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;

    static {
            try {
            	
            		//Configuration config = new Configuration();
        			//config.configure("hibernate.cfg.xml");
        			//config.addAnnotatedClass(EProduct.class);
        			//config.addResource("EProduct.hbm.xml");
                    StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                                    .configure("hibernate.cfg.xml").build();
                    
                   
            		// Comment this out
                    Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
                    sessionFactory = metaData.getSessionFactoryBuilder().build();
            } catch (Throwable th) {
                    throw new ExceptionInInitializerError(th);
            }
    }

    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }

	
}
