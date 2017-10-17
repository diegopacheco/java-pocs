package com.github.diegopacheco.sandbox.java.netflixoss.karyon.poc.jersey;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;

public class MainRunner {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		System.setProperty("archaius.deployment.environment","dev");
		
//		System.setProperty("eureka.region", "default");
//        System.setProperty("eureka.environment", "test");
//        System.setProperty("eureka.client.props", "eureka-client");
//		
//		 DiscoveryManager.getInstance().initComponent(
//	                new MyDataCenterInstanceConfig(),
//	                new DefaultEurekaClientConfig());
//		 
//		 ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.UP);
//	     DiscoveryClient discoveryClient = DiscoveryManager.getInstance().getDiscoveryClient();
//	     discoveryClient.registerHealthCheck(new HealthCheckHandler(){
//			@Override
//			public InstanceStatus getStatus(InstanceStatus currentStatus) {
//				return InstanceStatus.UP;
//			}
//	     });
//		
		netflix.karyon.KaryonRunner.main(new String[]{KaryonJerseyServerApp.class.getCanonicalName()});
	}
}
