package com.github.diegopacheco.sandbox.java.slang.fun;

import javaslang.Tuple;
import javaslang.Tuple2;

public class TupleMain {
	public static void main(String[] args) {
		
		final Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
		System.out.println(java8);
		
		final Tuple2<String, Integer> guessWhat = java8.map(
			    (s, i) -> Tuple.of(s + "slang", i / 4)
		);
		System.out.println(guessWhat);
		
	}
}
