package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.lifecycle;

import com.google.inject.Injector;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;

@SuppressWarnings("deprecation")
public class LifecycleExampleMain {
	
	public static void main(String[] args) throws Exception {
	
		Injector injector = LifecycleInjector.builder().createInjector();
        injector.getInstance(ExampleService.class);

        LifecycleManager manager = injector.getInstance(LifecycleManager.class);
        manager.start();
        manager.close();

	}
	
}
