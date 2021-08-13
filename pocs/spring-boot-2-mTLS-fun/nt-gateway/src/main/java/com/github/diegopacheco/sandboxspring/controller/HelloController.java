package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment env;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/mTLS", method = RequestMethod.GET)
	public String getMsData() {
		System.out.println("Got inside NT-GATEWAY-ms-data method");
		try {
			String msEndpoint = env.getProperty("endpoint.ms-service");
			System.out.println("MS Endpoint name : [" + msEndpoint + "]");

			return restTemplate.getForObject(new URI(msEndpoint), String.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Exception occurred.. so, returning default data";
	}

}