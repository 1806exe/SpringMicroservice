package com.hospital.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Hospital {
	
	@Id
	private Integer hospitalId;
	private String name;
	
	@Transient
	private List<Doctor> doctors;
	private String address;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	public Hospital(Integer hospitalId, String name, List<Doctor> doctors, String address) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.doctors = doctors;
		this.address = address;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalId=" + hospitalId + ", name=" + name + ", doctors=" + doctors + ", address=" + address
				+ "]";
	}
	
	

}
