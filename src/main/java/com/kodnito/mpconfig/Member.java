package com.kodnito.mpconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;


@Entity
@Table(name="member")
@SequenceGenerator(name="member_seq",initialValue=1,allocationSize=50)
@Getter
@Setter
public class Member implements Comparable<Member> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="member_seq")
	@Column(name="ID")
	private Long id;
	
	@NotNull
    @Column(name = "LAST_NAME")
	@JsonProperty
    private String lastName;
	
	
    @NotNull
    @Column(name = "FIRST_NAME")
    @JsonProperty
    private String firstName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(Member other) {
		// TODO Auto-generated method stub
		return other.compareTo(other);
	}

}
