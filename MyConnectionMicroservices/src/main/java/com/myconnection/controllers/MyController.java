package com.myconnection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myconnection.connection.MyConnection;

@RestController
public class MyController {
	
	@Autowired
	MyConnection myConnection;
	
	
	
	 @GetMapping("/connection-dynamic")
	 public MyConnection getConnectionValues() {
		 return new MyConnection(myConnection.getUsername(), myConnection.getPassword());
	 }
	

}
