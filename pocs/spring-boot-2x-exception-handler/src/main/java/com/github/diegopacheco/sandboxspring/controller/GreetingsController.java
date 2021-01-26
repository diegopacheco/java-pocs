package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class GreetingsController {

	@Autowired
	GreetingsService service;

	@RequestMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public String index() {
		return "Greetings from Spring Boot! try: /greet/{lang}";
	}

	@RequestMapping(value = "/greet/{lang}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String getGreetingByLanguage(@PathVariable("lang") String language) {
		String greet = service.getGreetingByLanguage(language);
		if (null==greet){
			throw new LanguageNotFoundException(language + " Not Found.");
		}
		return greet;
	}

	@ExceptionHandler(LanguageNotFoundException.class)
	public ResponseEntity<String> handleLNFException(LanguageNotFoundException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.BAD_REQUEST);
	}

}

