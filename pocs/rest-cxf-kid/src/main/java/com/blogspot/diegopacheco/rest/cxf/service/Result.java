package com.blogspot.diegopacheco.rest.cxf.service;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Result
 *
 * @author Diego Pacheco
 * @since  08/08/2010
 * @version 1.0
 *
 */
@XmlRootElement()
@XmlType(name = "", propOrder = {"value"})
public class Result {
	
	private Double value;
	
	public Result() {}
	
	public Result(Double value) {
		super();
		this.value = value;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
}
