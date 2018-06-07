package com.github.diegopacheco.sandbox.java.ssh.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-safe counters for success and errors.
 * 
 * @author diegopacheco
 *
 */
public class Counter {
	
	private AtomicInteger ok     = new AtomicInteger(0);
	private AtomicInteger error  = new AtomicInteger(0);
	
	public Integer incrementOk() {
		return ok.incrementAndGet();
	}
	
	public Integer incrementError() {
		return error.incrementAndGet();
	}
	
	public Integer getOk() {
		return ok.get();
	}
	public Integer getError() {
		return error.get();
	}

	@Override
	public String toString() {
		return "Counter [ok=" + getOk() + ", error=" + getError() + "]";
	}
	
}
