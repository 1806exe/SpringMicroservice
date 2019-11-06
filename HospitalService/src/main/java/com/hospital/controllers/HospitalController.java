package com.hospital.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.beans.Doctor;
import com.hospital.beans.Hospital;
import com.hospital.repository.HospitalRepository;

@RestController
public class HospitalController {
	
	@Autowired
	HospitalControllerProxy d_proxy;
	
	@GetMapping("/hospitals/{hospitalId}")
	public Hospital getHospitalDoctor(@PathVariable Long hospitalId) {
		
			Hospital hospital = d_proxy.getAllHospital(hospitalId);	
			return hospital;
	}

}
