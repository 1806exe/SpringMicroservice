package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableDiscoveryClient
public class SpringCloudApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiServiceApplication.class, args);
	}
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
