package com.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctor_id;
	private String name;
	private String specialization;
	private int hospital_id;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(int doctor_id, String name, String specialization, int hospital_id) {
		super();
		this.doctor_id = doctor_id;
		this.name = name;
		this.specialization = specialization;
		this.hospital_id = hospital_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", name=" + name + ", specialization=" + specialization
				+ ", hospital_id=" + hospital_id + "]";
	}
	

}
