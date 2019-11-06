package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services2")
public class MyController2 {
	
	@GetMapping("/services2-data")
	public List<String> getData(){
		List<String> list = new ArrayList<String>();
		list.add("KIDAWA");
		list.add("HAWA");
		list.add("GODLOVE");
		
		return list;
	}

}
