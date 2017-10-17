package com.github.diegopacheco.sandbox.java.vertx.fun;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.vertx.java.platform.Verticle;

public class SharedMapsz extends Verticle {
	
	@Override
	public void start() {
		ConcurrentMap<String, Integer> map = vertx.sharedData().getMap("demo.mymap");
		map.put("some-key", 123);
		
		Set<String> set = vertx.sharedData().getSet("demo.myset");
		set.add("some-value");
		
		System.out.println( map.get("some-key")  );
		System.out.println( set.iterator().next()  );
		
	}
	
}
