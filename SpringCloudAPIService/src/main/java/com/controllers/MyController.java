package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services1")
public class MyController {
	
	@GetMapping("/services1-data")
	public List<String> getData(){
		List<String> list = new ArrayList<String>();
		list.add("LILY");
		list.add("ROSE");
		list.add("SUNFLOWER");
		
		return list;
	}
	
	@GetMapping("/services1-data/headers")
	public List<String> getDat(@RequestHeader("request2")String header2){
		
		System.out.println("header" + header2);
		List<String> list = new ArrayList<String>();
		
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		
		return list;
	}

}
