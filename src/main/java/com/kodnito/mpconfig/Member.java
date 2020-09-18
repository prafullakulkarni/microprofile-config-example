package com.kodnito.mpconfig;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="member")
@SequenceGenerator(name="member_seq")
@Getter
@Setter
public class Member implements Comparable<Member> {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Member other) {
		// TODO Auto-generated method stub
		return other.compareTo(other);
	}

}
