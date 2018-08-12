package com.github.diegopacheco.async.java8.compostion;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleCompletableFuture {
	
	public static void main(String[] args) throws Throwable, Exception{
		
		ExecutorService es = Executors.newSingleThreadExecutor();

		Callable<String> task = () -> new Date().toString();
		Future<String> f = es.submit( task );
		System.out.println(f.get());
		
		CompletableFuture<String> cf = CompletableFuture.supplyAsync( () ->  "works" , es);  
		cf.thenAccept(System.out::println);
		
		es.shutdownNow();
	}
	
}
