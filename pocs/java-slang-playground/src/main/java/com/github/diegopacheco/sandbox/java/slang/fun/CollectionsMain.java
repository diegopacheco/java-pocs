package com.github.diegopacheco.sandbox.java.slang.fun;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;

import javaslang.collection.List;
import javaslang.collection.Stream;

public class CollectionsMain {
	public static void main(String[] args) {
		
		for (double random : Stream.gen(Math::random).take(1000)) {
		    System.out.println(random);
		}
		
		System.out.println( Arrays.asList(1, 2, 3).stream().reduce((i, j) -> i + j) );
		System.out.println( IntStream.of(1, 2, 3).sum() );
		System.out.println( List.of(1, 2, 3).sum() );
		
		System.out.println( Stream.gen( () -> 1 ).filter(i -> i % 2 == 0) );
		
		PrintStream out = System.out;
		
		Stream.of(0, 1, 2, 3, 13, 14, null, -1)
        .peek(n -> out.print( System.out.format(" STR %d -> ", n)))
        .forEach(out::println);
		out.flush();
				
	}
}
