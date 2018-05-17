package com.github.diegopacheco.sandbox.java.dummy;

import java.util.function.BiConsumer;

public class Main {
	public static void main(String[] args) throws Throwable {
		
		BiConsumer<String, String> callback = new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				 System.out.println("Okay... Key: " + t + " removed - value: " + u);
			}
		};
		
		TTLMap<String,String> map = new ConcurrentTTLMap<>(1000,1000,callback);
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
		System.out.println(map.get("C"));
		
		Thread.sleep(1000);
		map.put("A", "1");
		
		Thread.sleep(3000);
		System.out.println(map.get("D"));
		map.delete("Z");
		
		map.put("Z", "23");
		System.out.println(map.get("Z"));
	}
}
