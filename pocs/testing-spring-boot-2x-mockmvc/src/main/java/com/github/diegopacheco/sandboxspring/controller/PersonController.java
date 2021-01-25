package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Person;
import com.github.diegopacheco.sandboxspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

	@Autowired
	PersonService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping(value = "/person/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonById(@PathVariable("id") Integer id){
		Person p = service.getPersonById(id);
		if (null==p) throw new ResourceNotFoundException("Person with ID["+id+"] not found");
		return p;
	}

}

