package com.github.diegopacheco.java.pocs.caffeine.main;

import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.qual.NonNull;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class CaffeineMainFun {
	
	public static void main(String[] args) {
		
		LoadingCache<Integer, String> cache = Caffeine.newBuilder()
		    .maximumSize(10_000)
		    .expireAfterWrite(5, TimeUnit.MINUTES)
		    .refreshAfterWrite(1, TimeUnit.MINUTES)
		    .build(key -> createExpensiveValue(key));
		
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		
	}

	private static String createExpensiveValue(@NonNull Integer key) {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
		}
		return "V"+key;
	}
	
}
