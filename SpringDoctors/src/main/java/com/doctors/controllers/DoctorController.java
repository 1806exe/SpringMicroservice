package com.doctors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doctors.beans.Doctor;
import com.doctors.repository.DoctorRepository;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@GetMapping("/doctors/hospitalId/{hospitalId}")
	public List<Doctor> getDoctorsForHospital(@PathVariable int hospitalId){
		
		return doctorRepository.findAllByHospitalId(hospitalId);
		
	}
	
	
	@PostMapping("/doctors")
	public ResponseEntity<Doctor> addDoctors(@RequestBody Doctor doctor) {
		
		Doctor doc = doctorRepository.save(doctor);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<Doctor>(
				doc, HttpStatus.CREATED);
		return responseEntity;
		
	}
}
