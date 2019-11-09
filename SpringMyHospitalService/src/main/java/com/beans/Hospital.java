package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospital_id;
	private String hospital_name;
	private String region;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	public Hospital(int hospital_id, String hospital_name, String region) {
		super();
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.region = region;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + ", region=" + region + "]";
	}

}
