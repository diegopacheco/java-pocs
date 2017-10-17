package com.github.diegopacheco.sandbox.java.gdrl.guice;

public class PayPalPaymentService implements Payment {
	public Boolean pay(Integer id,Double value){
		return true;
	}
}
