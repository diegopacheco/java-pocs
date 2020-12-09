package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.dao.ThingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ThingController {

	@Autowired
	ThingDao dao;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot and Hibernate Reactive! Thing: " + dao.getThing(1L);
	}

}

