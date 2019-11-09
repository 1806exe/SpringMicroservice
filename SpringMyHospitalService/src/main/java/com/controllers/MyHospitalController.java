package com.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Hospital;
import com.repository.HospitalRepository;

@RestController
public class MyHospitalController {
	
	@Autowired
	HospitalRepository repo;
	
	@GetMapping("/hospitals")
	public List<Hospital> getAllHospitals() {
		return repo.findAll();
	}

	@PostMapping("/hospitals")
	public Hospital addMyHospital(@RequestBody Hospital hospital){
		return repo.save(hospital);
	}
	
	@GetMapping("hospital/{hospital_id}")
	public Hospital getHospitalById(@PathVariable int hospital_id) {
		Optional<Hospital> hospital = repo.findById(hospital_id);
		Hospital hospital_one = hospital.get();
		return hospital_one;
	}
	
	@PutMapping("hospital/{hospital_id}")
	public Hospital updateHospital(@PathVariable int hospital_id, @RequestBody Hospital hospital) {
		Optional<Hospital> hospital_ = repo.findById(hospital_id);
		Hospital hospital_one = hospital_.get();
		hospital_one.setHospital_name(hospital.getHospital_name());
		hospital_one.setRegion(hospital.getRegion());
		Hospital hosp = repo.save(hospital_one);
		return hosp;
	}
	
	@DeleteMapping("/hospital/{hospital_id}")
	public ResponseEntity<?> deleteHospital(@PathVariable int hospital_id) {
		Optional<Hospital> hospital = repo.findById(hospital_id);
		Hospital hospital_one = hospital.get();
		repo.delete(hospital_one);
		return ResponseEntity.ok().build();
	}

}
