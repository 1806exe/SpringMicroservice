package com.relation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name="Hospital_Rel")
public class Hospital_Rel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hospitalId;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="hospital_id")
	private List<Doctor_Rel> doctors;
	private String address;
	
	public Hospital_Rel() {
		// TODO Auto-generated constructor stub
	}

	public Hospital_Rel(Integer hospitalId, String name, List<Doctor_Rel> doctors, String address) {
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

	public List<Doctor_Rel> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor_Rel> doctors) {
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
		return "Hospital_Rel [hospitalId=" + hospitalId + ", name=" + name + ", doctors=" + doctors + ", address="
				+ address + "]";
	}

	

}
