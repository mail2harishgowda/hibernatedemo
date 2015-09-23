package com.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id @GeneratedValue
	private int vehicleId;
	private String name;
	
	@ManyToMany(mappedBy="vehicles")	
	private Collection<UserDetails> userDetails= new ArrayList<UserDetails>();
	
	
	
	
	public Collection<UserDetails> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Collection<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
