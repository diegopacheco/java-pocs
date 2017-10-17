package com.github.diegopacheco.sandbox.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedExecutorServiceSample {
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	class MyRunnable implements Runnable{		
		private Long l;		
		public MyRunnable(Long l) {
			this.l = l;
		}		
		@Override
		public void run() {
			try{
				Thread.sleep(5000L);
			}catch(Exception e){
				throw new RuntimeException(e);
			}			
			System.out.println( Thread.currentThread().getName() + " - " + l);
		}
	}
	
	public static void main(String[] args) {		
		for (int i = 0; i < 5; i++) {
			MyRunnable worker = new CachedExecutorServiceSample().new MyRunnable(10000000L + i);
			executor.execute(worker);
		}
		MyRunnable worker = new CachedExecutorServiceSample().new MyRunnable(666L);
		executor.execute(worker);
	
		System.out.println("Finished all threads");
		
	}
	
}
