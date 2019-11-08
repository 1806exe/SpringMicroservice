package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = "com")
@EnableZuulProxy
@EnableDiscoveryClient
@EnableAutoConfiguration
public class SpringNetflixApiServerApplication<ZuullLoggingFliter> {

	public static void main(String[] args) {
		SpringApplication.run(SpringNetflixApiServerApplication.class, args);
	}
	
	
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
