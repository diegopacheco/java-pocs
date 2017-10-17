package com.github.diegopacheco.sandbox.java.java8.fps;

import java.util.Date;
import java.util.function.Supplier;

public class Producers {
	
	@FunctionalInterface
	public interface Clock{
		String day();
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Clock c = () -> { return new Date().getDate() + ""; };
		System.out.println( c.day() );
		
		Supplier<String> c2 = () -> { return new Date().getDate() + ""; };
		System.out.println(c2.get());
		
	}
	
}
