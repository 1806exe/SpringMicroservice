package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

import reactor.core.publisher.Mono;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = "com")
@EnableWebFlux
public class SpringApiServerRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiServerRoutesApplication.class, args);
	}
	
	@Bean
	public GlobalFilter globalFilter() {
		return (exchange, chain)-> {
		System.out.println("First Gloabl filter");
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			System.out.println("Applying Filter");
		}));
		};
	}

}
