package com.github.diegopacheco.sandboxspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

import static java.lang.String.format;

@RestController
public class HelloController {

	@Autowired
	private ExecutorService executorService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/slow/{n}")
	public DeferredResult<String> slow(@PathVariable Integer n) {
		DeferredResult<String> output = new DeferredResult<>();
		try {
			Thread.sleep(n*1000L);
			output.setResult(format("ID for %s complete and order dispatched. Enjoy!", UUID.randomUUID().toString()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return output;
	}

	@GetMapping("/slow/async/{n}")
	public DeferredResult<String> slowWithExecutor(@PathVariable Integer n) {
		DeferredResult<String> output = new DeferredResult<>();
		executorService.execute(() -> {
			try {
				Thread.sleep(n*1000);
				output.setResult(format("[Executor] ID for %s complete and order dispatched. Enjoy!", UUID.randomUUID().toString()));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		return output;
	}

}

