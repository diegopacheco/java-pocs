package com.github.diegopacheco.async.java8.compostion;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.swing.SwingUtilities;

public class CompletableFutureComposition {
	
	public static void main(String[] args) {
		
		Executor executor = runnable -> SwingUtilities.invokeLater(runnable);  
		
		CompletableFuture.supplyAsync(  
		    () -> "Simple String"  
		)  
		.thenApply(CompletableFutureComposition::upper)
		.thenApply(CompletableFutureComposition::stars)  
		.thenAcceptAsync(  
				CompletableFutureComposition::dislay,
				executor
		);  
		
	}
	
	public static String stars(String s) {
		return "*" + s + "*";
	}
	
	public static String upper(String s) {
		return s.toUpperCase();
	}
	
	public static void dislay(String s) {
		System.out.println(s);
	}
	
}
