package com.blogspot.diegopacheco.rest.cxf.service.impl;

import com.blogspot.diegopacheco.rest.cxf.service.CalculatorService;
import com.blogspot.diegopacheco.rest.cxf.service.Result;

/**
 * SimpleCaculatorService default implementation of CaculatorService 
 *
 * @author Diego Pacheco
 * @since  08/08/2010
 * @version 1.0
 *
 */
public class SimpleCaculatorService implements CalculatorService{

	public SimpleCaculatorService() {}
	
	@Override
	public Double sum(Double value1, Double value2) {
		return value1 + value2;
	}
	
	@Override
	public Double sub(Double value1, Double value2) {
		return value1 - value2;
	}
	
	@Override
	public Double mul(Double value1, Double value2) {
		return value1 * value2;
	}
	
	@Override
	public Result div(Double value1, Double value2) {
		return new Result(value1 / value2);
	}
	

}
