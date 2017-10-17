package com.github.diegopacheco.sandbox.java8.lambdas;


public class StaticMethodRef {
	
	private static IntFI doLambda(){
		int x = 5;
		return y -> x + y;
	}
	
	public static void main(String[] args) {
		System.out.println(doLambda().apply(10));		
	}
}
