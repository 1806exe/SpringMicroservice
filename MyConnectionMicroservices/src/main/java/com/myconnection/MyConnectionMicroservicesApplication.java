package com.myconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableAutoConfiguration
public class MyConnectionMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyConnectionMicroservicesApplication.class, args);
	}

}
