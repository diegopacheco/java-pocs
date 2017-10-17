package com.github.diegopacheco.sandbox.java.netflixoss.governator.poc.validation.system;

import com.google.inject.Injector;
import com.netflix.governator.configuration.SystemConfigurationProvider;
import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import com.netflix.governator.guice.LifecycleInjector;
import com.netflix.governator.lifecycle.LifecycleManager;

public class ValidationExampleMain {
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("try 1");
			doWork();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		System.out.println("try 2");
		System.setProperty("value", "8");
		System.setProperty("str", "a string");
		doWork();
	}

	private static void doWork() throws Exception {
		Injector injector = LifecycleInjector.builder()
				.usingBasePackages("validation")
				.withBootstrapModule(new BootstrapModule() {
					@Override
					public void configure(BootstrapBinder binder) {
						binder.bindConfigurationProvider().to(SystemConfigurationProvider.class);
					}
				}).createInjector();

		LifecycleManager manager = injector.getInstance(LifecycleManager.class);
		manager.start();
		
		ExampleObject obj = injector.getInstance(ExampleObject.class);
		System.out.println(obj.getStr());
		System.out.println(obj.getValue());
		
		manager.close();
	}
}
