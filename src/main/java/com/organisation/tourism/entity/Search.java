package com.organisation.tourism.entity;

public class Search {
	String locationA;
	String locationB;
	public Search() {
		
	}
	public Search(String locationA, String locationB) {
		super();
		this.locationA = locationA;
		this.locationB = locationB;
	}
	public String getLocationA() {
		return locationA;
	}
	public void setLocationA(String locationA) {
		this.locationA = locationA;
	}
	public String getLocationB() {
		return locationB;
	}
	public void setLocationB(String locationB) {
		this.locationB = locationB;
	}
}
