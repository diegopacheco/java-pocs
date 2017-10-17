package com.github.diegopacheco.sandbox.java.ioreactor;

import reactor.Environment;
import reactor.rx.broadcast.Broadcaster;

public class SimpleReactor {

	static {
	  Environment.initialize();
	}
	
	public static void main(String[] args) throws Throwable {
			 
			Broadcaster<String> b = Broadcaster.create();
			 
			b
			  // dispatch onto a Thread other than 'main'
			  .dispatchOn(Environment.cachedDispatcher())
			  // transform input to UC
			  .map(String::toUpperCase)
			  // only let certain values pass through
			  .filter(s -> s.startsWith("HELLO"))
			  // produce demand
			  .consume(s -> System.out.println(Thread.currentThread() + ": " + s));
			 
			// Sink values into this Broadcaster
			b.onNext("Hello World!");
			// This won't print
			b.onNext("Goodbye World!");
			 
			// Must wait for tasks in other threads to complete
			Thread.sleep(5000);
	}
}
