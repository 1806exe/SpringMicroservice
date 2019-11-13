package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com")
@EntityScan(basePackages = "com")
@ComponentScan(basePackages = "com")
@RestController
public class SpringSecurityDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbApplication.class, args);
	}
	
	@GetMapping(path = "/user")
	public ResponseEntity listUser() {
		return new ResponseEntity("Got Data", HttpStatus.OK);
	}
}
