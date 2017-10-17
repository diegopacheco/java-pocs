package com.github.diegopacheco.zipkin.java.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ZipkinJavaFunApplication {

	private static final Logger LOG = Logger.getLogger(ZipkinJavaFunApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ZipkinJavaFunApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

	@RequestMapping("/")
	public String home() {
		LOG.log(Level.INFO, "you called home");
		return "Hello World";
	}

	@RequestMapping("/callhome")
	public String callHome() {
		LOG.log(Level.INFO, "calling home");
		return restTemplate.getForObject("http://localhost:8080", String.class);
	}
}
