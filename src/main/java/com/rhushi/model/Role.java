package com.rhushi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@SequenceGenerator(name = "role_seq")
@Getter
@Setter
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLE_NAME", nullable = false)
	@JsonProperty
	private String roleName;

	@ManyToMany
	@JoinTable(name = "MEMBER_ROLE", joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private Set<Member> members;

}
