package com.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyELKController {
	
	private static final Logger LOG = Logger.getLogger(MyELKController.class.getName());
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/elkdemo/{username}")
	public String showGreetings(@PathVariable String username) {
		String response = "Hello User ! " + username;
		LOG.log(Level.INFO, "/elkdemo - " + response);
		return response;
	}
	
	
	
	
	

}
