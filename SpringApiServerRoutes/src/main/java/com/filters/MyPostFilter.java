package com.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;


import reactor.core.publisher.Mono;


@Component
public class MyPostFilter extends AbstractGatewayFilterFactory<MyPostFilter.MyConfig>{
	
	public static class MyConfig{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public MyPostFilter() {
		// TODO Auto-generated constructor stub
		super(MyConfig.class);
	}

		@Override
		public GatewayFilter apply(MyConfig config) {
			System.out.println("********Inside the PostFilter********");
			return (exchange, chain)-> {
			
				return chain.filter(exchange).then(Mono.fromRunnable(()->{
					
					ServerHttpResponse response = exchange.getResponse();
					System.out.println("cookie read " + response.getCookies().get("myCookie"));
			
					
					HttpHeaders headers = exchange.getRequest().getHeaders();
					
					headers.forEach((k,v)->{
						System.out.println(k + ": " + v);
					});
					System.out.println("Post Filter");
				}));
				
			};
		}

}
