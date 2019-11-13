package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException {
		Users user = repository.findByUserName(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		System.out.println("Role:" + user.getRole());
		
		List<SimpleGrantedAuthority> authorities = Arrays
				.asList(new SimpleGrantedAuthority(user.getRole()));
		
		User user2 = new User(user.getUserName(), user.getPassword(), authorities);
		return user2;
		
		
	}

}
