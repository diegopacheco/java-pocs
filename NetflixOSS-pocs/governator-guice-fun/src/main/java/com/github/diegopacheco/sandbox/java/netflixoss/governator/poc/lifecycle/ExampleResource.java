package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleResource {
	
	@Inject
	public ExampleResource() {
		System.out.println("ExampleResource construction");
	}

	@PostConstruct
	public void setup() {
		System.out.println("ExampleResource setup");
	}

	@PreDestroy
	public void tearDown() {
		System.out.println("ExampleResource tearDown");
	}
}