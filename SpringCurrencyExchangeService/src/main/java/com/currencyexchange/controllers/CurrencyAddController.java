package com.currencyexchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
}
