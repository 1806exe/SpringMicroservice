package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bean.Book;

@Repository
public interface BookRepository 
extends ElasticsearchRepository<Book, String>{
	
	Page<Book> findByAuthor(String author, Pageable pageable);
	
	List<Book> findByTitle(String title);

}
