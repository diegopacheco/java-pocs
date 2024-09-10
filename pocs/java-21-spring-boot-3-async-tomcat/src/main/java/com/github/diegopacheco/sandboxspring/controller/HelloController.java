package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.AsyncDateService;
import com.github.diegopacheco.sandboxspring.service.BlockDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {

	@Autowired
	private AsyncDateService asyncService;

	@Autowired
	private BlockDateService blockService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/async-date")
	public CompletableFuture<String> executeAsyncTask() {
		return asyncService.getDateAsync();
	}

	@GetMapping("/block-date")
	public String executeBlockTask() {
		return blockService.getDateBlock();
	}

}

