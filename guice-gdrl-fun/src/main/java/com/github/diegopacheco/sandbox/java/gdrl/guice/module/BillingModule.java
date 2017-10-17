package com.github.diegopacheco.sandbox.java.gdrl.guice.module;

import com.github.diegopacheco.sandbox.java.gdrl.guice.Bill;
import com.github.diegopacheco.sandbox.java.gdrl.guice.BrazillianEletronicBill;
import com.github.diegopacheco.sandbox.java.gdrl.guice.PayPalPaymentService;
import com.github.diegopacheco.sandbox.java.gdrl.guice.Payment;
import com.github.diegopacheco.sandbox.java.gdrl.guice.annotations.bindings.NFE;
import com.github.diegopacheco.sandbox.java.gdrl.guice.logger.InfoLogger;
import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
	
	  @Override 
	  protected void configure() {
	    bind(Payment.class).to(PayPalPaymentService.class);
	    bind(InfoLogger.class);
	    bind(Bill.class).annotatedWith(NFE.class).to(BrazillianEletronicBill.class);
	  }
	
}
