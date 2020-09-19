package com.rhushi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="member",schema = "app")
@SequenceGenerator(name="member_seq")
public class Member  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="member_seq")
	@Column(name="ID")
	private Long id;
	
    @Column(name = "LAST_NAME",nullable=false)
	@JsonProperty
    private String lastName;
	
	
    @Column(name = "FIRST_NAME",nullable=false)
    @JsonProperty
    private String firstName;
    
    @JoinColumn(name = "MEMBER_ID")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Status> status; // + getter / setters
    
    @ManyToMany(mappedBy="members",cascade = CascadeType.ALL)
    private Set<Role> roles;
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public Set<Status> getStatus() {
		return status;
	}



	public void setStatus(Set<Status> status) {
		this.status = status;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

}
