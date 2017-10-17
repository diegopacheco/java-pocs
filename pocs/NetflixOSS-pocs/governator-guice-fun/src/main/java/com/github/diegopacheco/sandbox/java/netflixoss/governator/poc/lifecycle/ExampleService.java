package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleService {
	
	@Inject
	public ExampleService(ExampleResource resource) {
		System.out.println("ExampleService construction");
	}

	@PostConstruct
	public void setup() {
		System.out.println("ExampleService setup");
	}

	@PreDestroy
	public void tearDown() {
		System.out.println("ExampleService tearDown");
	}
}