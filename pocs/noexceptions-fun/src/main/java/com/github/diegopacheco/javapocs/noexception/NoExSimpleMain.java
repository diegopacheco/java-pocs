package com.github.diegopacheco.javapocs.noexception;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import com.machinezoo.noexception.Exceptions;

public class NoExSimpleMain {
	
	public static void main(String[] args) {
		
		System.out.println(Exceptions.log().get(() -> "test".substring(2)).orElse("fallback"));
		
		System.out.println(Exceptions.log().get(() -> "test".substring(5)).orElse("fallback"));
		
		byte[] utf = Exceptions.sneak().get(() -> "test".getBytes("UTF-8"));
		System.out.println(utf);
		
		final List<String> lines = Exceptions.log()
			    .get( Exceptions.sneak().supplier( () -> Files.readAllLines(Paths.get("/etc/hosts")) ))
			    .orElseGet( () ->  Collections.<String>emptyList() );
		for(String line : lines){
			System.out.println(line);
		}
	}
	
}
