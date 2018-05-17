package com.github.diegopaheco.sandbox.java8.enumz;

import java.util.Date;

/**
 * 
 * PROS:
 *   1. you dont need a switch
 *   2. the compiler will enforce you create print method if new type is added
 *   3. this dont create class proliferation
 * 
 * CONS:
 *   1. you cant inject on enum
 * 
 * @author diegopacheco
 *
 */
public class Printers {
	
	 enum Type {
		 
		 STAR{
			 @Override
			 public void print(String content) {
				 System.out.println("*** "  + content);
			 }
		 },
		 DOTS{
			 @Override
			 public void print(String content) {
				 System.out.println("... "  + content);
			 }
		 },
		 DATE{
			 @Override
			 public void print(String content) {
				 System.out.println(new Date().toString() + " " + content);
			 }
		 }
		 ;
		 
		 abstract public void print(String content);
	 }
	 
	 private Type t;
	 
	 public Printers(Type t) {
		super();
		this.t = t;
	}

	public void print(String content) {
		 t.print(content);
	 }
	
}
