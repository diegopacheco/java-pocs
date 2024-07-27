package com.github.diegopacheco.sandboxspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
	public String index() {
		logger.info("Handling index request");
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/error")
	public String error() {
		logger.error("Handling error request");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		Exception ex = new RuntimeException("Error fake", new RuntimeException("Error fake root"));
		ex.printStackTrace(pw);
		String sStackTrace = sw.toString();
		logger.error("Error with full stacktrace: " + sStackTrace);
		return sStackTrace;
	}

}

