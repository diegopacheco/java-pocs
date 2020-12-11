package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Pet;
import com.github.diegopacheco.sandboxspring.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@Autowired
	private PetService petService;

	@PostMapping("/pets")
	public ResponseEntity<Pet> createPet(@RequestBody Pet employee) {
		HttpStatus status = HttpStatus.CREATED;
		Pet saved = petService.save(employee);
		return new ResponseEntity<>(saved, status);
	}

	@GetMapping("/pets")
	public List<Pet> getAllEmployees() {
		return petService.getAllPets();
	}

}

