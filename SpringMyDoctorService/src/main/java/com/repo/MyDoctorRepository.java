package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beans.Doctor;

public interface MyDoctorRepository extends JpaRepository<Doctor, Integer> {

}
