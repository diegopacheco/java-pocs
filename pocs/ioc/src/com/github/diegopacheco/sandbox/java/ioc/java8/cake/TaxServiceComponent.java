package com.github.diegopacheco.sandbox.java.ioc.java8.cake;

public interface TaxServiceComponent extends TaxRepositoryComponent{
	default TaxService getTaxService() {
		return new TaxService(getTaxRepository());
	}
}
