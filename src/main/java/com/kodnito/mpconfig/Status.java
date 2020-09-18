package com.kodnito.mpconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="status")
@SequenceGenerator(name = "status_seq")
@Getter
@Setter
public class Status implements Comparable<Status> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="status_seq")	
    @Column(name = "ID")
    private Long id;
	
    @Column(name = "MEMBER_ID",nullable=false)
    private Long memberId;	

    @Column(name = "NAME",nullable = false)
    private String name;

    public Status() {
    }
	
    public Status(String name) {
      this.name = name;
    }	

    @Override
    public int compareTo(Status o) {
      return -o.name.compareTo(name);
    }

    // + getters and setters
}
