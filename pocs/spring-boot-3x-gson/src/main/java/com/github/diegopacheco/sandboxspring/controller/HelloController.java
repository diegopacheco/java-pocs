package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/champs")
	public List<Person> champs() {
		return List.of(new Person("John Doe", 40, "1234 main street, alaska","555-0430-245"),
				new Person("Marry Doe", 40,"2355 main street, alaska","555-5874-5566"),
				new Person("Champ",50, "2354 champ elysiums","444-5555-4444"));
	}

}

