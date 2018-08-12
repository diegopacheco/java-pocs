package com.github.diegopacheco.async.java8.compostion;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureJoin {
	
	public static void main(String[] args) {
		
		CompletableFuture<String> cf =  CompletableFuture.completedFuture("I'm done!");  
		cf.isDone(); // return true  
		String result = cf.join();   // return "I'm done"
		System.out.println(result);
		
	}
	
}
