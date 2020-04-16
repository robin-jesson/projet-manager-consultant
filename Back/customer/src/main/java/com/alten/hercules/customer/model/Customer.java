package com.alten.hercules.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customer_id;
	
	private String activitysector;
	
	private String description;
	
	private String name;
	
	

	public Customer() {
		super();
	}


	public Customer(long customer_id, String activitysector, String description, String name) {
		super();
		this.customer_id = customer_id;
		this.activitysector = activitysector;
		this.description = description;
		this.name = name;
	}

	
	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getActivity_sector() {
		return activitysector;
	}

	public void setActivity_sector(String activitysector) {
		this.activitysector = activitysector;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
