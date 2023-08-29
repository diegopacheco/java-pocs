package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		asyncMethodWithVoidReturnType();
		asyncMethodWithReturnType();
		blowIt();
		return "Greetings from Spring Boot!";
	}

	@Async
	public CompletableFuture<String> blowIt(){
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.completeAsync( () -> {
			throw new RuntimeException("Just dont like it");
		});
		return completableFuture;
	}

	@Async
	public void asyncMethodWithVoidReturnType() {
		try{
			Instant start = Instant.now();
			System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
			Thread.sleep(5000L);
			Instant end = Instant.now();
			System.out.println("Execution done: " + Duration.between(start,end).toMillis() + " ms");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Async
	public CompletableFuture<String> asyncMethodWithReturnType() {
		Instant start = Instant.now();
		System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
			Instant end = Instant.now();
			CompletableFuture<String> completableFuture = new CompletableFuture<>();
			completableFuture.completeAsync(() -> "42. Computed in: " + Duration.between(start, end).toMillis() + " ms");
			return completableFuture;
		} catch (Throwable e) {
			CompletableFuture<String> completableFuture = new CompletableFuture<>();
			completableFuture.completeExceptionally(e);
			return completableFuture;
		}
	}

}