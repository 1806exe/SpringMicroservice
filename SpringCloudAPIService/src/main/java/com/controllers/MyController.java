package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

}
