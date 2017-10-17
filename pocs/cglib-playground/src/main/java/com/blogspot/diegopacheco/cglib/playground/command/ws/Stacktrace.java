package com.blogspot.diegopacheco.cglib.playground.command.ws;

public class Stacktrace {

	public static void main(String[] args) {
		
		StackTraceElement stes[] = Thread.currentThread().getStackTrace();		
		for(StackTraceElement ste: stes){
			System.out.println( "Class: " + ste.getClassName() + ", method: " + 
								ste.getMethodName() + ", line: " + ste.getLineNumber()  );
		}
		
	}
}
