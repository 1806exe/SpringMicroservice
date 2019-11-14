package com.ripository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository(value = "userDao")
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
