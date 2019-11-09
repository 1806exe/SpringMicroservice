package com.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Doctor;
import com.repo.MyDoctorRepository;

@RestController
public class MyDoctorController {
	
	@Autowired
	MyDoctorRepository repo;
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return repo.findAll();
	}
	
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return repo.save(doctor);
	}

}
