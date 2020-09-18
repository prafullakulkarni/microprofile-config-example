package com.kodnito.mpconfig;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
			
			Set<Status> status = new HashSet<>();
			status.add(new Status("Platinum"));
			status.add(new Status("Priority"));
			
			member.setStatus(status);
			
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
