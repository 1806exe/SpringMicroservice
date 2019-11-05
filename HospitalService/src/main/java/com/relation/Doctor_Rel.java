package com.relation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Doctor_Rel")
public class Doctor_Rel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doctId;
	private String doctorName;
	private String specialization;
	
	public Doctor_Rel() {
		// TODO Auto-generated constructor stub
	}

	public Doctor_Rel(Integer doctId, String doctorName, String specialization) {
		super();
		this.doctId = doctId;
		this.doctorName = doctorName;
		this.specialization = specialization;
	}

	public Integer getDoctId() {
		return doctId;
	}

	public void setDoctId(Integer doctId) {
		this.doctId = doctId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor_Rel [doctId=" + doctId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ "]";
	}

	
	
	

}
