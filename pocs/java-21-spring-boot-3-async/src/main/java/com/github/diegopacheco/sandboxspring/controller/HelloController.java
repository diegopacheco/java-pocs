package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.AsyncDateService;
import com.github.diegopacheco.sandboxspring.service.AsyncMonoService;
import com.github.diegopacheco.sandboxspring.service.BlockDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {

	@Autowired
	private AsyncDateService asyncService;

	@Autowired
	private BlockDateService blockService;

	@Autowired
	private AsyncMonoService asyncMonoService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/async-date")
	public CompletableFuture<String> executeAsyncTask() {
		return asyncService.getDateAsync();
	}

	@GetMapping("/mono-date")
	public Mono<String> executeMonoTask() {
		return asyncMonoService.getDateAsync().subscribeOn(Schedulers.boundedElastic());
	}

	@GetMapping("/block-date")
	public String executeBlockTask() {
		return blockService.getDateBlock();
	}

}

