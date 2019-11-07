package com.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;


@Component
public class MyPreFilter extends AbstractGatewayFilterFactory<MyPreFilter.MyConfig>{
	
	public static class MyConfig{
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
	
	public MyPreFilter() {
		// TODO Auto-generated constructor stub
		super(MyConfig.class);
	}
	
	@Override
	public GatewayFilter apply(MyConfig config) {
		System.out.println("********This is a pre Filter********");
		return (exchange, chain)-> {
			System.out.println("Headers" + exchange.getRequest().getHeaders());
			ServerHttpRequest modifiedRequest = exchange.getRequest().mutate().header("request2", "new header").build();
			
			return chain.filter(exchange.mutate().request(modifiedRequest).build());
		};
	}
	
}
