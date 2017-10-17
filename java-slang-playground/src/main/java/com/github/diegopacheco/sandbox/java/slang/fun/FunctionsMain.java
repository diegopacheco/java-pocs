package com.github.diegopacheco.sandbox.java.slang.fun;

import javaslang.Function1;
import javaslang.Function2;

public class FunctionsMain {
	public static void main(String[] args) {
		
		final Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
		final Function1<Integer, Integer> add2 = sum.curried().apply(2);
		
		System.out.println( sum );
		System.out.println( add2 );
		
		System.out.println( sum.apply(1, 3)  );
		System.out.println( add2.apply(1)  ); 
		
	}
}
