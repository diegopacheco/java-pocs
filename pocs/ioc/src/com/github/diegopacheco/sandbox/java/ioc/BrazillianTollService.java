package com.github.diegopacheco.sandbox.java.ioc;

public class BrazillianTollService implements TaxService{
	@Override
	public Double tollOneWay() {
		return 4.95D;
	}
}
