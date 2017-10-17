package com.github.diegopacheco.sandbox.java.java8.fps;

public class FunctionalInterfaceFun {
	
	@FunctionalInterface
	public interface Func{
		public void doIt();
	}
	
	public static void main(String[] args) {
		
		Func f = () -> System.out.println("Hello!");
		f.doIt();
	}
	
}
