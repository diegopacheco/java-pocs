package com.github.diegopacheco.sandbox.java8.lambdas.func;

import java.util.function.Function;

public class FunctionMain {
	public static void main(String[] args) {
		
		Function<Integer, Integer> inc = x -> x + 1;
		
		int result = inc.apply(5);
		
		System.out.println(result);
		
	}
}
