package com.kodnito.mpconfig;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class MemberDAO {

	@PersistenceContext(unitName="default")
	private EntityManager em;

	public List<Member> allMembers() {
		TypedQuery<Member> q = em.createQuery("SELECT m FROM Member m", Member.class);
		List<Member> l = q.getResultList();
		return l;
	}

	public Member getMember(Long id) {
		return em.find(Member.class, id);
	}

	public Long newMember(String lastName, String firstName) {
		Member m = new Member();
		m.setFirstName(firstName);
		m.setLastName(lastName);
		em.persist(m);
		em.flush(); // needed to get the ID
		return m.getId();
	}

	public void updateMember(String lastName, String firstName, Long id) {
		Member m = em.find(Member.class, id);
		m.setLastName(lastName);
		m.setFirstName(firstName);
		em.persist(m);
	}
	public void deleteMember(Long id) {
	      Member m = em.find(Member.class, id);
	      em.remove(m);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
