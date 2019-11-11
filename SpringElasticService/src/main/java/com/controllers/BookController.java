package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Book;
import com.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/{id}")
	public Optional<Book> getBookById(@PathVariable String id){
		return bookService.findOne(id);
	}
	
	@PostMapping
	public Book insertBook(@RequestBody Book book) throws Exception{
		System.out.println("called");
		return bookService.save(book);
	}
	
	@GetMapping
	public Iterable<Book> getBooks(){
		return bookService.findAll();
	}
	
	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable String id){
		Book book = new Book();
		book.setId(id);
		bookService.delete(book);
	}

}
