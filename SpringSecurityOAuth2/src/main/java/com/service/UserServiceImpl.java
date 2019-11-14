package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.User;
import com.ripository.UserRepository;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserRepository userDao;
	
	public UserDetails loadUserByUsername(String userId)
		throws UsernameNotFoundException {
		
		User user = userDao.findByUsername(userId);
		
		if (user == null ) {
			throw new UsernameNotFoundException("invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), getAuthority());
	}
	
	
	private List<SimpleGrantedAuthority> getAuthority(){
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	
	public List<com.model.User> findAll(){
		List<com.model.User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
		
	}
	
	@Override
	public com.model.User save(com.model.User user) {
		
		return userDao.save(user);
	}
	

}
