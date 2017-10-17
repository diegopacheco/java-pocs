package com.github.diegopacheco.java.sandbox.java8.lambok.dsl;

public class SetterFunMain {
	public static void main(String[] args) {
		
		Configs c = Configs.dsl()
						   .url("http://www.google.com")
						   .os("windows")
						   .host("localhost").build();
		
		System.out.println(c);
		
	}
}
