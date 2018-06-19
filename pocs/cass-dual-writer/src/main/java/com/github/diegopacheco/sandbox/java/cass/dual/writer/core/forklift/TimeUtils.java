package com.github.diegopacheco.sandbox.java.cass.dual.writer.core.forklift;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
	
	public static String format(Long millis) {
		String time = String.format("%d min, %d sec", 
		    TimeUnit.MILLISECONDS.toMinutes(millis),
		    TimeUnit.MILLISECONDS.toSeconds(millis) - 
		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
		);
		return time;
	}
	
}
