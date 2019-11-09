package com.currencyexchange.controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.bean.ExchangeValue;
import com.currencyexchange.exceptions.NoValuePresentException;
import com.currencyexchange.repository.CurrencyExchnageRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	CurrencyExchnageRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-exchange/to/{to}/from/{from}")
	@HystrixCommand(commandProperties = {
			@HystrixProperty(
					name = "execution.isolation.thread.timeoutInMilliseconds", value = "12000"
					)
	})
	public ExchangeValue getExchangeValue(@PathVariable String to, @PathVariable String from
		) {
		
		logger.info("path varibale in exchange service --> {} from:- " + from + "to" + to);
		try {
			Thread.sleep(9000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to).get();
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
		
	}

}
