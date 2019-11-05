package com.currencyexchange.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.bean.ExchangeValue;
import com.currencyexchange.repository.CurrencyExchnageRepository;

@RestController
public class CurrencyAddController {
	
	@Autowired
	CurrencyExchnageRepository  repo;
	
	
	@PostMapping("/values")
	public ExchangeValue addExchangeValue(@RequestBody ExchangeValue exchangeValue) {
		 System.out.println("exchange values " + exchangeValue);
		//repo.save(exchangeValue);
		return exchangeValue;
	}
	
	@PostMapping("/values/entity")
	public ResponseEntity<ExchangeValue> addExchangeValueEntity(@RequestBody ExchangeValue exchangeValue) {
		 System.out.println("exchange values ENTITY " + exchangeValue);
		//repo.save(exchangeValue);
		
		ExchangeValue exchangeValue1 = repo.save(exchangeValue);	
		ResponseEntity<ExchangeValue> responseEntity = new ResponseEntity<ExchangeValue>(
				exchangeValue1, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/values/delete/entity/id/{id}")
	public ResponseEntity<?> deleteExchangeValue(@PathVariable Long id) {
		
		Optional<ExchangeValue> exchangeValue = repo.findById(id);
		
		if(exchangeValue.isPresent()) {
			repo.deleteById(id);
		}
		
		return ResponseEntity.ok().build();
		
	}
	
//	@PutMapping("/values/update/entity/{id}")
//	public ResponseEntity<?> updateExchangeValue(@PathVariable Long id, @RequestBody ExchangeValue exchangeValue){
//		ExchangeValue ex = repo.findById(id);
//		
//	}
	
	
	
}
