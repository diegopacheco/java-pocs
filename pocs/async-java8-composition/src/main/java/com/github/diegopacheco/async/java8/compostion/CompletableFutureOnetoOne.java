package com.github.diegopacheco.async.java8.compostion;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureOnetoOne {
	
	public static void main(String[] args) {
		
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> "Hello world");  
		CompletableFuture<String> cf2 = cf1.thenApply(s -> s + " from the Future!");  
		CompletableFuture<Void>   cf3 = cf2.thenAccept(System.out::println);  
		CompletableFuture<Void>   cf4 = cf3.thenRun(() -> System.out.println("Done processing this chain"));  
		System.out.println(cf4.isDone());
	}
	
}
