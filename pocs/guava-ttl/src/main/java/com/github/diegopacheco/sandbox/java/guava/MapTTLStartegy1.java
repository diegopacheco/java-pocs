package com.github.diegopacheco.sandbox.java.guava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * KEEP IN MIND EVICTION ONLY HAPPENS WHEN SOMEONE WRITE SOMETHING ON THE MAP.
 * 
 * @author diegopacheco
 *
 */
public class MapTTLStartegy1 {
	
	static Cache<String, List<String>> cache; 
	
	public static void main(String[] args) throws Throwable {
		
			RemovalListener<String, List<String>> listener = new RemovalListener<String, List<String>>() {
				@Override
				public void onRemoval(RemovalNotification<String, List<String>> notification) {
					System.out.println(notification + " has experid"); 
					// get part of the list back to the main cache - here we are evicting 2c only.
					cache.put(notification.getKey(), Arrays.asList(notification.getValue().get(0), notification.getValue().get(1))); 
				}
			};
			
			cache = CacheBuilder.newBuilder()
			     .maximumSize(100)
			     .expireAfterAccess(3, TimeUnit.SECONDS)
			     .removalListener(listener)
			     .build();
			
			cache.put("clusterA", Arrays.asList("2A","2B","2C"));
			
			System.out.println(cache);
			System.out.println("clusterA: " + cache.getIfPresent("clusterA"));
			System.out.println("clusterB: " + cache.getIfPresent("clusterB"));
			
			Thread.sleep(5000L);
			System.out.println("clusterA: " + cache.getIfPresent("clusterA"));
			
			cache.put("clusterB", Arrays.asList("1A","1B","1C"));
			System.out.println("clusterB: " + cache.getIfPresent("clusterB"));
			System.out.println("clusterA: " + cache.getIfPresent("clusterA"));
		
	}
}
