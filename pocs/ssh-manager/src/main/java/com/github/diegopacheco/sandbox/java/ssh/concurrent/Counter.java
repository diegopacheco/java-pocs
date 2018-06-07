package com.github.diegopacheco.sandbox.java.ssh.concurrent;

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
		return (ok.get()==0) ? 0 : ok.get() + 1;
	}
	public Integer getError() {
		return (error.get()==0) ? 0 : error.get() + 1;
	}

	@Override
	public String toString() {
		return "Counter [ok=" + getOk() + ", error=" + getError() + "]";
	}
	
}
