package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Person;
import com.github.diegopacheco.sandboxspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	PersonService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/all")
	public List<Person> getAllThePeople() {
		return service.getAllPeople();
	}

	@RequestMapping("/save/{id}/{fn}/{ln}")
	public String savePerson(
			@PathVariable("id") Long id,
			@PathVariable("fn") String firstName,
			@PathVariable("ln") String lastName)
	{
		Person p = new Person(id,firstName, lastName);
		service.save(p);
		return "Person saved!";
	}

}

