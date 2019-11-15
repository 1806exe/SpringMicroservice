package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@EnableOAuth2Sso
@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(basePackages = "com")
@EnableDiscoveryClient
@EntityScan("com.model")
@EnableJpaRepositories("com")
@EnableAuthorizationServer
@EnableAutoConfiguration
public class SpringSecurityOAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOAuth2Application.class, args);
	}

}
