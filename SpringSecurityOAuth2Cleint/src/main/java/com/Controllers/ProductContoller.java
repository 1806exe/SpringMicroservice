package com.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.beans.Product;
import com.beans.User;
import com.proxy.UserExchangeProxy;

import feign.RequestInterceptor;



@RestController
public class ProductContoller {
	
	@Autowired
	UserExchangeProxy proxy;
	
	
	@Bean
	public RequestInterceptor oauth2FeignRequest(OAuth2ClientContext oAuth2ClientContext,
			OAuth2ProtectedResourceDetails resource) {
		return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, resource);
	}
	
	
	
	@Bean
	public ResourceOwnerPasswordResourceDetails getResourceDetails() {
		ResourceOwnerPasswordResourceDetails resourceDetails = 
				new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setGrantType("password");
		resourceDetails.setAccessTokenUri("http://localhost:9595/oauth/token");
		
		// -- set the client client info --
		resourceDetails.setClientId("client1");
		resourceDetails.setClientSecret("password");
		
		// set scopes
		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		resourceDetails.setScope(scopes);
		
		// set resource owner info
		resourceDetails.setUsername("Innocent");
		resourceDetails.setPassword("letmepass");
		return resourceDetails;
	}
	
	
	@Bean
	public OAuth2ClientContext oauth2ClientContext() {
		DefaultOAuth2ClientContext defaultOAuth2ClientContext = new DefaultOAuth2ClientContext();
		return defaultOAuth2ClientContext;
	}
	
	
	@Bean
	private OAuth2RestTemplate restTemplate() {
		System.out.println("getting OAuth2RestTemplate......");
		return new OAuth2RestTemplate(getResourceDetails());
	}
	
	
	
	
	@GetMapping("/product_access")
	public Product getAllProduct_access() {
		List<User> users = new ArrayList<>();
		Product product = new Product(1, "Coca Cola", users);
		
		OAuth2AccessToken accessToken = restTemplate().getAccessToken();
		String token = accessToken.getValue();
		System.out.println("Token -> " + token);
		users = proxy.listUser();
		product.setUsers(users);
		return product;
	}
	
	
	
	
	

}
