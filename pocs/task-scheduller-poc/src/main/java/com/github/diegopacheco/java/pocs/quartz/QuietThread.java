package com.github.diegopacheco.java.pocs.quartz;

public class QuietThread {
	public static void sleep(Integer time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}
}
