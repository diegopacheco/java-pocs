package com.github.diegopacheco.java8.sandbox.fp;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducerConsumerMain {
	
	public static void main(String[] args) {
		
		print(new Supplier<String>() {
			@Override
			public String get() {
				return "Hello World";
			}
		});
		print( ()->  "Hello World 2" );
		
		print2("Hello World 3 ", new Consumer<String>() {
				public void accept(String t) {
					  System.out.println(t.toUpperCase());
				}
		});
		
		print2("Hello World 4 ", (s)-> System.out.println(s.toUpperCase()));
		
	}
	
	private static void print(Supplier<String> messageSupplier) {
		System.out.println("** " + messageSupplier.get());
	}
	
	private static void print2(String msg,Consumer<String> messageConsumer) {
		messageConsumer.accept(msg);
	}
	
}
