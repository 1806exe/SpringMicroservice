package com.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@SpringBootApplication(scanBasePackages="com")
@EntityScan(basePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.*")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringCurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
