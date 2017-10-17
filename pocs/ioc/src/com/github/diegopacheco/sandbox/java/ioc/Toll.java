package com.github.diegopacheco.sandbox.java.ioc;

public class Toll {
	
	private TaxService ts;
	
	public Double operate(Car c){
		Double tax = ts.tollOneWay();
		Double gain = tax + 2;
		System.out.println("[INFO] For the car: " + c.model);
		System.out.println("[INFO] You need pay: " + gain);
		return gain;
	}

	public void setTs(TaxService ts) {
		this.ts = ts;
	}
	
}
