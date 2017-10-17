package com.github.diegopacheco.sandbox.java.java8.fps;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
	
	public static String func(Supplier<String> s){
		return s.get();
	}
	
	public static String funcRef(String value,Function<String,String> f){
		return f.apply(value);
	}
	
	public static void main(String[] args) {
		
		String s1 = "Hello FP";
		
		System.out.println( func( new Supplier<String>() {
			@Override
			public String get() {
				return "Hello FP";
			}
		}) );
		
		System.out.println( func(() -> s1.toString()) );
		
		System.out.println( func(s1::toString) );
		
		//
		// method ref func
		//
		
		System.out.println( funcRef("teste", String::toUpperCase) );
		
		System.out.println( funcRef("teste", x -> x.toUpperCase() ) );
		
	}
	
}
