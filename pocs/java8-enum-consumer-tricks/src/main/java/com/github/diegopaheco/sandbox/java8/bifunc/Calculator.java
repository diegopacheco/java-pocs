package com.github.diegopaheco.sandbox.java8.bifunc;

import java.util.function.BiFunction;

public class Calculator {
	
	public Integer calc(Integer a, Integer b,BiFunction<Integer,Integer, Integer> func) {
		return func.apply(a, b);
	}
	
}
