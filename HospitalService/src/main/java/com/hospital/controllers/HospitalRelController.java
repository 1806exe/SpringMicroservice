package com.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.repository.Hospital_Rel_Repository;
import com.relation.Hospital_Rel;

@RestController
public class HospitalRelController {
	
	@Autowired
	Hospital_Rel_Repository rel_repo;
	
	@PostMapping("/hospitals")
	public Hospital_Rel addNewHospital(@RequestBody  Hospital_Rel hospital_Rel) {
		return rel_repo.save(hospital_Rel);
	}
}
