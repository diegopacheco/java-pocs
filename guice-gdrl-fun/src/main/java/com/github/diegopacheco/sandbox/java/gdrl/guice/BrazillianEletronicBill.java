package com.github.diegopacheco.sandbox.java.gdrl.guice;

import javax.inject.Inject;

import com.github.diegopacheco.sandbox.java.gdrl.guice.logger.InfoLogger;

public class BrazillianEletronicBill implements Bill{
	
	private InfoLogger logger;
	
	@Inject
	public BrazillianEletronicBill(InfoLogger logger) {
		super();
		this.logger = logger;
	}

	@Override
	public void doit() {
		logger.info("Done. NFE works. ");
	}
}
