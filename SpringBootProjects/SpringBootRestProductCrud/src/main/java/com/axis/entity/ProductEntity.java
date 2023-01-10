package com.axis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductList")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="Product Name")
	private String name;
	@Column(name="Items Count")
	private int noOfitems;
	@Column(name="Product Cost")
	private int cost;
	public ProductEntity() {
		
	}
	
	public ProductEntity(String name, int noOfitems, int cost) {
		super();
		this.name = name;
		this.noOfitems = noOfitems;
		this.cost = cost;
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
	public int getNoOfitems() {
		return noOfitems;
	}
	public void setNoOfitems(int noOfitems) {
		this.noOfitems = noOfitems;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
