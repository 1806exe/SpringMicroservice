package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableFeignClients(basePackages = "com")
@EnableDiscoveryClient
public class SpringSecurityOAuth2CleintApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOAuth2CleintApplication.class, args);
	}

}
