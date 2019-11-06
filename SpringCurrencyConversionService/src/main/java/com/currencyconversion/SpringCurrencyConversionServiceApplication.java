package com.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com")
@EnableFeignClients(basePackages="com")
@EnableEurekaClient
public class SpringCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCurrencyConversionServiceApplication.class, args);
	}

}
