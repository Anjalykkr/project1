package com.organisation.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tourpackage")
public class TourPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotEmpty(message="Package name cannot be null")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message="Location must be specified")
	@Column(name="from_location")
	private String fromLocation;
	
	@NotEmpty(message="Location must be specified")
	@Column(name="to_location")
	private String toLocation;
	
	@NotNull
	@Min(value=1,message="Number of days must be specified")
	@Column(name="no_of_days")
	private int noOfDays;
	
	@NotNull
	@Min(value = 500, message = "Price should not be less than 500")
	@Column(name="price")
	private double price;
	
	public TourPackage() {
		// TODO Auto-generated constructor stub
	}

	public TourPackage(String name, String fromLocation, String toLocation, int noOfDays, double price) {
		this.name = name;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.noOfDays = noOfDays;
		this.price = price;
	}

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

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TourPackage [id=" + id + ", name=" + name + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", noOfDays=" + noOfDays + ", price=" + price + "]";
	}
	

}
