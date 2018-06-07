package com.github.diegopacheco.sandbox.java.process;

import java.util.concurrent.atomic.AtomicInteger;

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
		return "Counter [ok=" + ok.get() + ", error=" + error.get() + "]";
	}
	
}
