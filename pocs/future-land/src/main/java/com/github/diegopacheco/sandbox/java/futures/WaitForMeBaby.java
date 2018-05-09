package com.github.diegopacheco.sandbox.java.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WaitForMeBaby {
	
	public static <T> CompletableFuture<T> toCompletableFuture(Future<T> future) {
    return CompletableFuture.supplyAsync(() -> {
        try {
            return future.get();
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        }
    });
}
	
	public static void main(String[] args) throws Throwable{

		Callable<String> taskFather = () -> {
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Father DONE");
				return "Father";
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		Callable<String> taskMother = () -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Mother DONE");
				return "Mother";
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		Callable<String> taskSon = () -> {
			try {
				TimeUnit.SECONDS.sleep(3);
				System.out.println("Son DONE");
				return "Son";
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(3);

		Future<String> f1 = executor.submit(taskFather);
		Future<String> f2 = executor.submit(taskMother);
		Future<String> f3 = executor.submit(taskSon);
		
		CompletableFuture.allOf(toCompletableFuture(f1),toCompletableFuture(f2),toCompletableFuture(f3));
		System.out.println("All done!");
				
		executor.shutdownNow();
	}
}
