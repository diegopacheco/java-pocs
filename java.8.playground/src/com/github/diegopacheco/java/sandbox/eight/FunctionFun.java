package com.github.diegopacheco.java.sandbox.eight;

import java.util.function.Function;

public class FunctionFun {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> pow = (Integer a) -> a * a;
		System.out.println( pow.apply(6) );
		
	}

}
