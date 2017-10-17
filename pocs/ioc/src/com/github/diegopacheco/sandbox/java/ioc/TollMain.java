package com.github.diegopacheco.sandbox.java.ioc;

public class TollMain {
	public static void main(String[] args) {
		Toll t = new Toll();
		t.setTs(new BrazillianTollService());
		Car c = new Car();
		c.model = "Gol";
		System.out.println( t.operate(c) );
	}
}
