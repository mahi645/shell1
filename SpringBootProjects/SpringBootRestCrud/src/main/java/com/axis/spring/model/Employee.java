package com.axis.spring.model;

import jakarta.persistence.Column;

//import org.hibernate.annotations.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp4")


public class Employee {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="Name")
	private String name;
	@Column(name="Department")
	private String dept;
	public Employee(long id,String name,String dept) {
		super();
		this.id=id;
		this.name=name;
		this.dept=dept;
		
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	

}
