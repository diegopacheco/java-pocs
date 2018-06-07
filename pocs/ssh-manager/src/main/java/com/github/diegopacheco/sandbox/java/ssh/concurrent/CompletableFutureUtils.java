package com.github.diegopacheco.sandbox.java.ssh.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

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
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public static <T> CompletableFuture<T> makeCompletableFutureSync(Future<T> future) {
		try {
			return CompletableFuture.completedFuture(future.get());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SafeVarargs
	public static <T> void wait(CompletableFuture<T>... cfs) {
		CompletableFuture.allOf(cfs);
	}

	@SafeVarargs
	public static <T> CompletableFuture<List<T>> waitAndAggregate(CompletableFuture<T> ...cfs){
		 List<CompletableFuture<T>> futuresList = Arrays.asList(cfs);
		
		 CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
	   return allDoneFuture.thenApply(v ->
	    								futuresList.stream().
	                    map(future -> future.join()).
	                    collect(Collectors.<T>toList())
	   );
		
	}
}