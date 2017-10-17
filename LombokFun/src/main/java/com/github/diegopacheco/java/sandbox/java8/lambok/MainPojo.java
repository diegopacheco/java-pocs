package com.github.diegopacheco.java.sandbox.java8.lambok;

public class MainPojo {
	
	public static void main(String[] args) {
		
		SimplePojo sp = new SimplePojo("Diego");
		sp.setCountry("Brazil");
		
		System.out.println(sp);
		System.out.println(sp.equals(sp));
		System.out.println(sp.hashCode());
		
	}
	
}
