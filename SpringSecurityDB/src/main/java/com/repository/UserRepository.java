package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{
	Users findByUserName(String username);

}
