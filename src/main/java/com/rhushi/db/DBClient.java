package com.rhushi.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rhushi.model.Member;
import com.rhushi.model.Role;
import com.rhushi.model.Status;

public class DBClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager eman = emf.createEntityManager();

		try {

			// EntityManagerFactory emFactory = (EntityManagerFactory)
			// Persistence.createEntityManagerFactory(DB_NAME, props);

			eman.getTransaction().begin();
			
			Member member1 = new Member();
			member1.setFirstName("rhushikesh");
			member1.setLastName("velankar");
			
			Member member2 = new Member();
			member2.setFirstName("shruti");
			member2.setLastName("velankar");
			
			
			Status platinum1 = new Status();
			platinum1.setName("platinum");
			
			Status diamond1 = new Status();
			diamond1.setName("diamond");
			
			Set<Status> status1 = new HashSet<>();
			status1.add(platinum1);
			status1.add(diamond1);
			
			Status platinum2 = new Status();
			platinum2.setName("platinum");
			
			
			Set<Status> status2 = new HashSet<>();
			status2.add(platinum2);
			
			
			member1.setStatus(status1);
			member2.setStatus(status2);
			
			
			Set<Member> members =  new HashSet<>();
			members.add(member1);
			members.add(member2);
			
			Role adminRole = new Role();
			adminRole.setRoleName("Admin");
			adminRole.setMembers(members);
			
			
			Role consultantRole = new Role();
			consultantRole.setRoleName("Consultant");
			consultantRole.setMembers(members);
			
			
			Set<Role> roles = new HashSet<>();
			roles.add(consultantRole);
			roles.add(adminRole);
			
			member1.setRoles(roles);
			member2.setRoles(roles);
			
			
			eman.persist(member1);
			eman.persist(member2);
			
			eman.getTransaction().commit();

		} catch (Exception e) {
			//eman.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
