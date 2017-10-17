package com.github.diegopacheco.sandbox.java.java8.fps;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {
	
	static Predicate<String> plural = (s) -> s.contains("s");
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("cars","chars","nothing","tweets","john");
		
		words.stream()
			  .filter(plural)
			  .forEach(System.out::println);
		
	}
}
