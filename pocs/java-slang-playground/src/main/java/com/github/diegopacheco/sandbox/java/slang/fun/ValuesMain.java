package com.github.diegopacheco.sandbox.java.slang.fun;

import javaslang.Lazy;
import javaslang.collection.List;
import javaslang.control.Option;
import javaslang.control.Try;

public class ValuesMain {
	public static void main(String[] args) {
		
		final Lazy<String> lazy = Lazy.of( () -> "10"  );
		final Option<String> option = Option.of("");
		final Try<String> tryy = Try.of( () -> "10" );
		final List<String> list = List.of("");
		
		System.out.println(lazy);
		System.out.println(option);
		System.out.println(tryy);
		System.out.println(list);
		
	}
}
