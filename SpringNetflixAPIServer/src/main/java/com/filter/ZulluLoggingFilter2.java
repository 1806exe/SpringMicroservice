package com.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ch.qos.logback.classic.Level;

@Component
public class ZulluLoggingFilter2 extends ZuulFilter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Override
	public Object run() throws ZuulException{
		System.out.println("Hello");
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request ---> {} request URI -> {} " + request, request.getRequestURI());
		logger.info("PRE filter called ", Level.INFO);
		System.out.println("************************** request -->{} request URI-> {} " + request + " " + request.getRequestURI()+ "*****************************************");
		return null;
	}
	
	@Override
	public boolean shouldFilter() {
//		String header = RequestContext.getCurrentContext().getRequest()
//				.getHeader("filter");
//		if(header.equals("true")) {
//			return true;
//		}
//		
		return true;
	}
	
	@Override
	public int filterOrder() {
		return 2;
	}
	
	@Override
	public String filterType() {
		return "pre";
	}
	
}
