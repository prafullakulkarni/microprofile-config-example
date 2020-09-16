package com.kodnito.mpconfig;

import java.util.Properties;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

public class DBClient {
	
	

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		 EntityManager eman = emf.createEntityManager();

		try {
			
			// EntityManagerFactory emFactory = (EntityManagerFactory)
			// Persistence.createEntityManagerFactory(DB_NAME, props);
			 
			 eman.getTransaction().begin();
			 Member member = new Member();
			 member.setFirstName("rhushikesh");
			 member.setLastName("velankar");
			 eman.persist(member);
			 eman.getTransaction().commit();
			 
		} catch (Exception e) {
			eman.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
