package com.example.circular.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	int id;
	String name;
	double cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Product(int id, String name, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
