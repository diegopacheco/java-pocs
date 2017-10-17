package com.github.diegopacheco.java.sandbox.java8.lambok;

import lombok.LazyGetter;

public class LazyGetterFun {

	@LazyGetter
	private final double[] cached = expensive();

	private double[] expensive() {
		double[] result = new double[1000000];
		for (int i = 0; i < result.length; i++) {
			result[i] = Math.asin(i);
		}
		return result;
	}

	public static void main(String[] args) {
		LazyGetterFun z = new LazyGetterFun();
		System.out.println(z.expensive());
		System.out.println(z.expensive());
		System.out.println(z.expensive());
		
	}
}
