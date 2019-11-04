package com.currencyexchange.controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.bean.ExchangeValue;
import com.currencyexchange.exceptions.NoValuePresentException;
import com.currencyexchange.repository.CurrencyExchnageRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchnageRepository repository;
	
	@GetMapping("/currency-exchange/to/{to}/from/{from}")
	public ExchangeValue getExchangeValue(@PathVariable String to, @PathVariable String from) {
		Optional<ExchangeValue>optional=repository.findByFromAndTo(from, to);
		if (optional.isPresent()) {
			ExchangeValue exchangeValue = repository.findByFromAndTo(from, to).get();
			exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return exchangeValue;
		}else {
			 throw new NoValuePresentException();
		}
	}

}
