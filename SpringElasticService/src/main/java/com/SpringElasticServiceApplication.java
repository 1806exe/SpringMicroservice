package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = "com")
public class SpringElasticServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticServiceApplication.class, args);
	}

}
