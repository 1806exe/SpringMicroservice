package com.currencyconversion.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.currencyconversion.bean.CurrencyConversion;

@FeignClient(value = "currency-conversion-service", url="http://localhost:8000")
public interface CurrencyExchangeProxy {
	
	
	@GetMapping("/currency-exchange/to/{to}/from/{from}")
	public CurrencyConversion getExchange(
			@PathVariable("from") String from, @PathVariable("to") String to);
	
	@PostMapping("/values/entity")
	CurrencyConversion create(@RequestBody CurrencyConversion currencyConversion);
	
	@DeleteMapping("/values/delete/entity/id/{id}")
	CurrencyConversion delete(@PathVariable Long id);
}