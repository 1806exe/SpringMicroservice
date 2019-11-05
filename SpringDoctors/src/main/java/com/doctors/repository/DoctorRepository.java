package com.doctors.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctors.beans.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	List<Doctor>findAllByHospitalId(int hospitalId);
}

