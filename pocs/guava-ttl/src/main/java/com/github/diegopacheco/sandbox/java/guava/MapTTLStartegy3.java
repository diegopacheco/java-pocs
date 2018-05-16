package com.github.diegopacheco.sandbox.java.guava;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class MapTTLStartegy3 {
	
	static Map<String,String> realCache = new ConcurrentHashMap<>();
	static Cache<String, String> cache; 
	
	public static void main(String[] args) throws Throwable {
			
		cache = CacheBuilder.newBuilder()
		     .maximumSize(100)
		     .expireAfterAccess(3, TimeUnit.SECONDS)
		     .build(new CacheLoader<String, String>() {
           public String load(String key) {
          	 return realCache.get(key);
           }
    });
		
		cache.put("clusterA-2A", "10.25.0.15");
		cache.put("clusterA-2B", "10.25.0.16");
		cache.put("clusterA-2C", "10.25.0.17");
		realCache.put("clusterA-2A", "10.25.0.15");
		realCache.put("clusterA-2B", "10.25.0.16");
		realCache.put("clusterA-2C", "10.25.0.17");
		
		System.out.println(cache);
		System.out.println("clusterA-2A: " + cache.getIfPresent("clusterA-2A"));
		System.out.println("clusterA-2B: " + cache.getIfPresent("clusterA-2B"));
		System.out.println("clusterA-2C: " + cache.getIfPresent("clusterA-2C"));
		
		Thread.sleep(5000L);
		System.out.println("clusterA-2A: " + cache.getIfPresent("clusterA-2A"));
		
		cache.put("clusterB-1A", "10.25.0.20");
		cache.put("clusterB-1B", "10.25.0.16");
		cache.put("clusterB-1C", "10.25.0.17");
		realCache.put("clusterB-1A", "10.25.0.20");
		realCache.put("clusterB-1B", "10.25.0.16");
		realCache.put("clusterB-1C", "10.25.0.17");
		System.out.println("clusterA-2B: " + cache.getIfPresent("clusterA-2B"));
		System.out.println("clusterA-2C: " + cache.getIfPresent("clusterA-2C"));
		System.out.println("clusterA-1A: " + cache.getIfPresent("clusterB-1A"));
		System.out.println("clusterA-1B: " + cache.getIfPresent("clusterB-1B"));
		System.out.println("clusterA-1C: " + cache.getIfPresent("clusterB-1C"));
		
	}
	
}
