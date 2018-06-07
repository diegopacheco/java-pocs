package com.github.diegopacheco.sandbox.java.ssh.concurrent;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility Methods for CompletableFutures.
 * 
 * @author diegopacheco
 *
 */
public class CompletableFutureUtils {
	
	public static <T> CompletableFuture<T> makeCompletableFuture(Future<T> future) {
    return CompletableFuture.supplyAsync(() -> {
        try {
            return future.get();
        } catch (InterruptedException|ExecutionException e) {
        	throw new RuntimeException(e);
        }
    });
	}
	
	public static <T> CompletableFuture<T> makeCompletableFutureSync(Future<T> future) {
		try {
			return CompletableFuture.completedFuture( future.get() );
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@SafeVarargs
	public static <T> void wait(CompletableFuture<T> ...cfs){
		CompletableFuture.allOf(cfs);
	}
	
	@SafeVarargs
	public static <T> List<T> waitAndAggregate(CompletableFuture<T> ...cfs){
		
		Function<CompletableFuture<T>,T> mapper = new Function<CompletableFuture<T>, T>() {
			@Override
			public T apply(CompletableFuture<T> t) {
				try {
					return t.get();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		return Stream.of(cfs).map( mapper ).collect(Collectors.toList());
	}
	
}