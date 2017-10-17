package com.github.diegopacheco.sandbox.java.slang.fun;

import java.io.IOException;

import javaslang.Function1;
import javaslang.control.Try;
import javaslang.control.Try.CheckedConsumer;

public class FunctionalInterfaceSteroidsMain {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		final Function1<Object, Integer> hash = Object::hashCode;
		final Function1<Object,Integer> hashCache = Function1.lift(Object::hashCode).reversed();
		final Class<?> returnType = hash.getType().returnType();

		System.out.println(hash);
		System.out.println(hashCache);
		System.out.println(returnType);
		
		final Try.CheckedRunnable performIO = () -> { System.out.println("Hi"); };
		Try.run(performIO).onFailure( (CheckedConsumer<Throwable>) new IOException("X") );
		
	}
}
