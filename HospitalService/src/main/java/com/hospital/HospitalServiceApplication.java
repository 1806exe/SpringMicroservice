package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com")
@EntityScan(basePackages = "com")
@EnableJpaRepositories(basePackages = "com")
@EnableFeignClients(basePackages="com")
public class HospitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServiceApplication.class, args);
	}

}
