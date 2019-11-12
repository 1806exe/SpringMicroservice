package com.controllers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class MyELKController {

	private static final Logger LOG = Logger.getLogger(MyELKController.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	
	
	@GetMapping(value = "/elkdemo/{username}")
	public String showGreetings(@PathVariable String username) {
		String response = "Hello User ! " + username;
		LOG.log(Priority.INFO, response);
		return response;
	}

	
	
	@RequestMapping(value = "/elkdemo/user/{username}")
	public String calculate(@PathVariable String username) {
		ParameterizedTypeReference<Map<String, String>> tpeRef = new ParameterizedTypeReference<Map<String, String>>() {
		};
		String response = restTemplate.exchange("http://localhost:7171/elkdemo/" + username, HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, tpeRef).getBody().toString();

		LOG.log(Priority.INFO, response);

		try {

			String exception = restTemplate.exchange("http://localhost:7171/exception/", HttpMethod.GET, null,
					new ParameterizedTypeReference<String>() {
					}, tpeRef).getBody().toString();
			LOG.log(Priority.INFO, exception);
			response = response + " === " + exception;

		} catch (Exception e) {

		}

		return response;
	}
	
	
	

	@RequestMapping(value = "/exception")
	public String exception() {
		String rsp = "";
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info(e.getMessage());
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace();
			String sStackTrace = pw.toString(); // stack trace string
			LOG.info("Exception As String :: - &gt; " + sStackTrace);
			rsp = sStackTrace;
		}
		return rsp;

	}

}
