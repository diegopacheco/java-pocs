package com.github.diegopacheco.sandbox.java.java8.fps;

import java.util.function.Consumer;

public class Consumers {

	@FunctionalInterface
	public interface Printer{
		void print(String source);
	}
	
	Printer p = (String s) -> { System.out.println("* " + s + " *"); };
	
	public static void main(String[] args) {
		Consumers c = new Consumers();
		c.p.print("test");
		
		Consumer<String> c2 = (String s) -> { System.out.println("* " + s + " *"); };
		c2.accept("test");
	}
	
}
