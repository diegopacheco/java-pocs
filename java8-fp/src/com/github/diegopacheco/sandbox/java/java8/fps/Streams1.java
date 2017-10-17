package com.github.diegopacheco.sandbox.java.java8.fps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Streams1 {
	public static void main(String[] args) {
			
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		numbers.stream()
			   .map( (n) -> n + 1 )
			   .forEach(System.out::println);
		
		Optional<Integer> result = 
			numbers.stream()
				   .filter( (n) -> n%2==0 )
				   .map( (n) -> n + 1 )
				   .reduce( (x,y) -> x + y );
		System.out.println(result);
		
		Optional<Integer> result2 = 
				numbers.stream()
					   .filter( (n) -> n%7==0 )
					   .map( (n) -> n + 1 )
					   .reduce( (x,y) -> x + y );
		System.out.println(result2);

			
	}
}
