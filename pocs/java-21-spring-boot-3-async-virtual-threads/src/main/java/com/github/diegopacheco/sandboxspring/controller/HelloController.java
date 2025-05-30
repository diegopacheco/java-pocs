package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.config.VirtualThreadScheduler;
import com.github.diegopacheco.sandboxspring.service.AsyncDateService;
import com.github.diegopacheco.sandboxspring.service.AsyncMonoService;
import com.github.diegopacheco.sandboxspring.service.BlockDateService;
import com.github.diegopacheco.sandboxspring.service.NoBlockService;
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

	@Autowired
	private NoBlockService noBlockService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/stress-benchmark-01")
	public CompletableFuture<String> executeAsyncTask() {
		return asyncService.getDateAsync();
	}

	@GetMapping("/stress-benchmark-02")
	public Mono<String> executeMonoTask() {
		return asyncMonoService.getDateAsync().subscribeOn(Schedulers.boundedElastic());
	}

	@GetMapping("/stress-benchmark-03")
	public Mono<String> executeMonoNoBlockTask() {
		return noBlockService.getDateAsync().subscribeOn(VirtualThreadScheduler.virtualThreadScheduler());
	}

	@GetMapping("/stress-benchmark-04")
	public String executeNoBlockTask() {
		return noBlockService.getDate();
	}

	@GetMapping("/stress-benchmark-05")
	public String executeBlockTask() {
		return blockService.getDateBlock();
	}

	@GetMapping("/stress-benchmark-06")
	public CompletableFuture<String> executeAsyncReallyTask() {
		return asyncService.getDateAsyncReallyAsync();
	}

}

