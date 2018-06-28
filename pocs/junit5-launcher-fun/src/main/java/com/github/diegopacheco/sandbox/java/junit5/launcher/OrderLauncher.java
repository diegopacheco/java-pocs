package com.github.diegopacheco.sandbox.java.junit5.launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.LoggingListener;

public class OrderLauncher {
	
	public static void main(String[] args) throws Throwable {
		
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
		    .selectors(
		        selectPackage("com.example.mytests")
		    )
		    .filters(
		        includeClassNamePatterns(".*Test")
		    )
		    .build();

		Launcher launcher = LauncherFactory.create();
		TestPlan testPlan = launcher.discover(request);
		System.out.println(testPlan);
		
		TestExecutionListener listener = LoggingListener.forJavaUtilLogging();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		
		Thread.sleep(3000L);
	}
	
}
