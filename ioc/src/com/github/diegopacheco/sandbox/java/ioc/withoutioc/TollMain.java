package com.github.diegopacheco.sandbox.java.ioc.withoutioc;

public class TollMain {
	public static void main(String[] args) {
		Toll t = new Toll();
		Car c = new Car();
		c.model = "Gol";
		System.out.println( t.operate(c) );
	}
}
