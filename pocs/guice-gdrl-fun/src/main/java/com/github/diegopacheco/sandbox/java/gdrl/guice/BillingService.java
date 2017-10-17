package com.github.diegopacheco.sandbox.java.gdrl.guice;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.diegopacheco.sandbox.java.gdrl.guice.annotations.bindings.NFE;
import com.github.diegopacheco.sandbox.java.gdrl.guice.logger.InfoLogger;

public class BillingService {

    private Payment payment;
    private InfoLogger logger;
    private Bill bill;
    private String locale;

    @Inject
    public BillingService(Payment payment,
    					  InfoLogger logger,
    					  @NFE Bill bill,
    					  @Named("locale") String locale){
        this.payment = payment;
        this.logger = logger;
        this.bill = bill;
        this.locale = locale;
    }
    
    public Boolean bill(Integer id){
    	logger.info("Billing for " + id + " from: " + locale);
    	Boolean result = payment.pay(id, 10.0);
    	logger.info("Billing result for { " + id + ", 10.00 } = " + result);
    	bill.doit();
    	return result;
    }

}
