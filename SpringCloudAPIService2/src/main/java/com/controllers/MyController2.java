package com.controllers;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	
	@GetMapping("/services2-data/headers")
	public List<String> getHeader(HttpServletRequest request, @RequestHeader Map<String, String> headers, HttpServletResponse response){
		Enumeration<String> enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		Cookie cookie = new Cookie("myCookie", "ABCDEFG");
		response.addCookie(cookie);
		
		List<String> list = new ArrayList<String>();
		headers.forEach((k,v)->{
			list.add(v);
		});
	return list;
	
	}
}
