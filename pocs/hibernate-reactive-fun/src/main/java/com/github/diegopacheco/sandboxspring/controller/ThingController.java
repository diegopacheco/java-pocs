package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.dao.ThingDao;
import com.github.diegopacheco.sandboxspring.model.Thing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RestController
public class ThingController {

	@Autowired
	ThingDao dao;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot and Hibernate Reactive! Thing: " + dao.getThing(1L);
	}

	@RequestMapping("/mono")
	public Mono<Thing> mono() {
		return dao.getMonoThing(1L);
	}

}

