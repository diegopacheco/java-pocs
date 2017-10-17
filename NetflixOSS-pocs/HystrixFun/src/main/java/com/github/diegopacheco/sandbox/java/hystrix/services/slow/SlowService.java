package com.github.diegopacheco.sandbox.java.hystrix.services.slow;

import com.github.diegopacheco.sandbox.java.hystrix.services.Service;

public class SlowService implements Service{
	
	@Override
	public Object execute(Object args) {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return "OK";
	}
	
}
