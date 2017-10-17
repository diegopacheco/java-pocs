package com.github.diegopacheco.sandbox.java.ioc.java8.cake;

public class TollMain {
	public static void main(String[] args) {
		Car c = new Car();
		c.model = "Gol";
		LocalApp app = new LocalApp();
		System.out.println( app.getTaxRepository().tollOneWay() );
	}
}
