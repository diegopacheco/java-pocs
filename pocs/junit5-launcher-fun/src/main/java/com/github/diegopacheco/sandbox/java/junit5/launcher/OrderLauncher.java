package com.github.diegopacheco.sandbox.java.junit5.launcher;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.LoggingListener;

public class OrderLauncher {
	
	public static void main(String[] args) throws Throwable {
		
		LogManager.getLogManager().readConfiguration(
				new FileInputStream( 
						new File(".").getCanonicalPath() + "/src/main/resources/" +  "logging.properties"));
		
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
		System.out.println(testPlan.containsTests());
		
		TestExecutionListener listener = LoggingListener.forJavaUtilLogging(Level.ALL);
		launcher.registerTestExecutionListeners(listener);
		launcher.execute(request);
		
		Thread.sleep(5000L);
	}
	
}
