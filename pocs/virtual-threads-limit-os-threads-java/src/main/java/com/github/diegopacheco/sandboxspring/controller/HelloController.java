package com.github.diegopacheco.sandboxspring.controller;

import org.apache.tomcat.util.threads.VirtualThreadExecutor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

	private static int MAX_OS_THREADS = 2;

	private ExecutorService pool =
			Executors.newFixedThreadPool(2,Thread.ofVirtual().factory());

	@RequestMapping("/")
	public String index() throws InterruptedException {
		AtomicInteger atomic = new AtomicInteger(0);
		pool.submit( ()-> atomic.incrementAndGet() );
		pool.submit( ()-> atomic.incrementAndGet() );
		pool.submit( ()-> atomic.incrementAndGet() );

		pool.awaitTermination(2, TimeUnit.SECONDS);
		return "count: " + atomic.get();
	}

}

