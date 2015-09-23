package com.demo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="USER_DETAILS")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,region="userdetails")
public class UserDetails {
	
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	
	
	@Column(name="DESCRIPTION")
	private String description;
	
/*	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(
			name="USER_ADDRESS",
			joinColumns=@JoinColumn(name="USER_ID")			
			)*/
	//@OneToMany(mappedBy="userDetails")	
	/*@JoinTable(name="USER_VEHICLE",
	   joinColumns=@JoinColumn(name="USER_ID"),
	   inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
			)*/
	@ManyToMany	
	@JoinTable(name="USER_VEHICLE",
	   joinColumns=@JoinColumn(name="USER_ID"),
	   inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
	)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	//private Address address;
	
	
	/*@AttributeOverrides({		
		@AttributeOverride( name = "city", column=@Column( name="HOME_CITY")),
		@AttributeOverride( name = "street", column=@Column( name="HOME_STREET")),
		@AttributeOverride( name = "state", column=@Column( name="HOME_STATE")),
		@AttributeOverride( name = "pincode", column=@Column( name="HOME_PINCODE"))		
		
	})
	
	private Address homeaddress;
	
	
	
	public Address getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	} */
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
