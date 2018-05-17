package com.github.diegopaheco.sandbox.java8.enumz.consumers;

import java.util.function.Consumer;

public class Printers {
	
	enum Type{
		
			DATE(DatePrinter::print),
			DOT(DotPrinter::go),
			STAR(StarPrinter::doit)
			;
		
			public final Consumer<String> printLogic;
			private Type(Consumer<String> printLogic) {
				this.printLogic = printLogic;
			}
	}
	
	 private Type t;
	 public Printers(Type t) {
		super();
		this.t = t;
	 }
	 
	 public void print(String content) {
			 t.printLogic.accept(content);
	 }
	 
}
