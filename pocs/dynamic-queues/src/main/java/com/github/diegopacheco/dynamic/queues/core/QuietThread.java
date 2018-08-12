package com.github.diegopacheco.dynamic.queues.core;

public class QuietThread {
	public static void sleep(Integer time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}
}