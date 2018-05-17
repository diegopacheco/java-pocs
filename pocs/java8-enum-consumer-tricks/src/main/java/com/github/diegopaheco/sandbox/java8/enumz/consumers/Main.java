package com.github.diegopaheco.sandbox.java8.enumz.consumers;

import com.github.diegopaheco.sandbox.java8.enumz.consumers.Printers.Type;

public class Main {
	public static void main(String[] args) {
		
		Printers p = new Printers(Type.STAR);
		p.print("Hi");
		
		p = new Printers(Type.DATE);
		p.print("Hi");
		
		p = new Printers(Type.DOT);
		p.print("Hi");
		
	}
}
