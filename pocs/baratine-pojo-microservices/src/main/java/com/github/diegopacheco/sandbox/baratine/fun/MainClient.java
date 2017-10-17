package com.github.diegopacheco.sandbox.baratine.fun;

import io.baratine.core.ServiceManager;

public class MainClient {
	public static void main(String[] args) {

		ServiceManager manager = ServiceManager.current();
		Hello hello = manager.lookup("/hello").as(Hello.class);
		System.out.println("Hello: " + hello.hello());

	}
}
