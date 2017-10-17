package com.github.diegopacheco.sandbox.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {
	
	class MyRunnable implements Runnable{		
		private Long l;		
		public MyRunnable(Long l) {
			this.l = l;
		}		
		@Override
		public void run() {
			System.out.println( Thread.currentThread().getName() + " - " + l);
		}
	}
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 500; i++) {
			MyRunnable worker = new ExecutorServiceSample().new MyRunnable(10000000L + i);
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {}
		
		System.out.println("Finished all threads");
		
	}
	
}
