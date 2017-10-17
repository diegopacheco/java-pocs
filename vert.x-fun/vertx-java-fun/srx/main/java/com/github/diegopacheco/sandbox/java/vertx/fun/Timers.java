package com.github.diegopacheco.sandbox.java.vertx.fun;

import java.util.Date;

import org.vertx.java.core.Handler;
import org.vertx.java.platform.Verticle;

public class Timers extends Verticle {

	@Override
	public void start() {
		long timerID = vertx.setTimer(1000, new Handler<Long>() {
			public void handle(Long timerID) {
				getContainer().logger().info("And one second later this is printed");
			}
		});
		System.out.println(timerID);
		
		long timerID2 = vertx.setPeriodic(1000, new Handler<Long>() {
		    public void handle(Long timerID) {
		    	getContainer().logger().info("And every second this is printed periodic all the time " + new Date().getSeconds());
		    }
		});

	}

}
