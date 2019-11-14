package com.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	// @RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping("/user")
	public List listUser() {
		return userService.findAll();
	}
	
	@PostMapping(value = "/user")
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	
	
	@DeleteMapping(value = "user/{id}")
	public String delete(@PathVariable(value  = "id") Long id) {
		userService.delete(id);
		return "success";
	}
	
	@GetMapping(value = "/hello")
	public List list() {	
		return userService.findAll();
	}
	

}
