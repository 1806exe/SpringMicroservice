package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// create two user for demo
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	
	auth.inMemoryAuthentication()
	.withUser("user").password("{noop}user").roles("USER").and()
	.withUser("admin").password("{noop}admin").roles("ADMIN").and()
	.withUser("both").password("{noop}both").roles("USER", "ADMIN");
	
	}
	
	// secure the end point with HTTP Basic Authentication
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/books/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/books").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/books/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PATCH, "/books/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/books/**").hasAnyRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}
	

}
