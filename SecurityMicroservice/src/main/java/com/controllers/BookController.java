package com.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@GetMapping("/books")
	public String allData() {
		return "Welcome Inncoent";
	}
	
	@PostMapping("/books")
	public String addData() {
		return "adding book";
	}
	
	@PutMapping("/books/{id}")
	public String updateData(@PathVariable int id) {
		return "update " + id;
	}
	
	@DeleteMapping("books/{id}")
	public String deleteData(@PathVariable int id) {
		return "deleted " + id;
	}

}
