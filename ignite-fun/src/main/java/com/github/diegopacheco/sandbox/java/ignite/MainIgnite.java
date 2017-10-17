package com.github.diegopacheco.sandbox.java.ignite;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;

public class MainIgnite {
	public static void main(String[] args) throws Throwable {

		try (Ignite ignite = Ignition
				.start("" + new File(".").getCanonicalPath() + "/src/main/resources/example-ignite.xml")) {
			Collection<IgniteCallable<Integer>> calls = new ArrayList<>();

			for (final String word : "Count characters using callable".split(" "))
				calls.add(word::length);

			Collection<Integer> res = ignite.compute().call(calls);
			int sum = res.stream().mapToInt(Integer::intValue).sum();
			System.out.println("Total number of characters is '" + sum + "'.");

			IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");
			for (int i = 0; i < 10; i++)
				cache.put(i, Integer.toString(i));

			for (int i = 0; i < 10; i++)
				System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
		}

	}
}
