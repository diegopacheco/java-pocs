package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.SimpleCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RestController
public class HelloController {

	@Autowired
	private SimpleCache sc;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/cache")
	public String cache() {
		String cache = sc.get("mycache");
		if (cache==null){
			cache=new Date().toString();
			sc.set("mycache",cache);
		}
		return cache;
	}

}