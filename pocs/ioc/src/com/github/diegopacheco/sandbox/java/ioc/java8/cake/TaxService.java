package com.github.diegopacheco.sandbox.java.ioc.java8.cake;

public class TaxService {
	
	private TaxRepository repository;
	
	TaxService(TaxRepository repository) {
		this.repository = repository;
	}
	
	public Double tollOneWay(){
		return repository.tollOneWay();
	}
	
}
