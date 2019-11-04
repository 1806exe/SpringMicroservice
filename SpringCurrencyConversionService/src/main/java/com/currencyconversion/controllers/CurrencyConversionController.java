package com.currencyconversion.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconversion.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-conversion-msg")
	public String message() {
		return "Currency Conversion";
	}
	
	@GetMapping("currency-convert-dummy/to/{to}/from/{from}/quantity/{quantity}")
	public CurrencyConversion convertCurrency_dummy(@PathVariable String to, @PathVariable String from,
			@PathVariable String quantity) {
		return new CurrencyConversion(to, from, BigDecimal.valueOf(65), BigDecimal.valueOf(Double.parseDouble(quantity)), BigDecimal.valueOf(65000));
	}
	
	@GetMapping("currency-convert/to/{to}/from/{from}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {
		
		Map<String, String> uriVariable = new HashMap<>();
		
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/to/{to}/from/{from}", CurrencyConversion.class, uriVariable);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		currencyConversion.setQuantity(BigDecimal.valueOf(Integer.parseInt(quantity)));		
		currencyConversion.setTotalCalculatedAmount(currencyConversion.getConversionMultiple().multiply(currencyConversion.getQuantity()));
		
		
		return currencyConversion;
		
		
	}
	
	@PostMapping("/conversionvalues")
	public CurrencyConversion addCurrencyConversion(@RequestBody CurrencyConversion currencyConversion) {
		String REQUEST_URI = "http://localhost:8000/values";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(REQUEST_URI, currencyConversion, CurrencyConversion.class);
		return currencyConversion;
	}
	
	
	@PostMapping("/conversionvalues/entity")
	public ResponseEntity<CurrencyConversion> addCurrencyConversionEntity(@RequestBody CurrencyConversion currencyConversion) {
		String REQUEST_URI = "http://localhost:8000/values/entity";
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("User-Agent", "Conversion demo Class");
		headers.add("Accept-Language", "en-us");
		HttpEntity<CurrencyConversion> entity = new HttpEntity<CurrencyConversion>(currencyConversion, headers);
		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.postForEntity(REQUEST_URI, entity, CurrencyConversion.class);
		// responseEntity.status(HttpStatus.CREATED);
		return responseEntity;
	}
	
}
