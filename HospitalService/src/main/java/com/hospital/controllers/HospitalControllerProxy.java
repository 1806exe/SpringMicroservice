package com.hospital.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hospital.beans.Hospital;

@FeignClient(value = "doctors-service", url="http://localhost:9000")
public interface HospitalControllerProxy {
	
	@GetMapping("/hospital/hospitalId/{hospitalId}")
	public Hospital getAllHospital(@PathVariable Long hospitalId);

}
