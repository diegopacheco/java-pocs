package com.github.diegopacheco.sandbox.java.ioc.java8.cake;


interface BrazillianTollService extends TaxRepositoryComponent {
    default TaxRepository getTaxRepository() {
        return new TaxRepository() {
        	public Double tollOneWay(){
        		return 6.95;
        	}
        };
    }
}

class LocalApp implements TaxServiceComponent, BrazillianTollService {}
