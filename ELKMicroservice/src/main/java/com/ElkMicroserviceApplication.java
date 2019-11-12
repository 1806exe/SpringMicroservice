package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = "com")
public class ElkMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElkMicroserviceApplication.class, args);
	}

}
