package com.myconnection.connection;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "connection-service")
public class MyConnection {
	
	
	private String username, password;

	public MyConnection() {
		super();
	}

	public MyConnection(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MyController [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
