package com.github.diegopacheco.sandbox.java.junit5.launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class OrderLauncher {
	
	public static void main(String[] args) throws Throwable {
		
		LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
		    .selectors(
		        selectPackage("com.example.mytests")
		        //,selectClass(MyTestClass.class)
		    )
		    .filters(
		        includeClassNamePatterns(".*Tests")
		    )
		    .build();

		Launcher launcher = LauncherFactory.create();
		TestPlan testPlan = launcher.discover(request);
		System.out.println(testPlan);
		
		TestExecutionListener listener = new SummaryGeneratingListener();
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		
		Thread.sleep(3000L);
	}
	
}
