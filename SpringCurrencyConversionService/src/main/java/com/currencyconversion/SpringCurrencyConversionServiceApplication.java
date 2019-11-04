package com.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCurrencyConversionServiceApplication.class, args);
	}

}
