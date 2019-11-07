package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableDiscoveryClient
public class SpringCloudApiService2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiService2Application.class, args);
	}

}
