package com.doctors.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctorId;
	private String doctorname;
	private String specialization;
	private Integer hospitalId;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(Integer doctorId, String doctorname, String specialization, Integer hospitalId) {
		super();
		this.doctorId = doctorId;
		this.doctorname = doctorname;
		this.specialization = specialization;
		this.hospitalId = hospitalId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorname=" + doctorname + ", specialization=" + specialization
				+ ", hospitalId=" + hospitalId + "]";
	}
	
}
