package com.ilegra.training.spring.integration.simple;

/**
 * HelloService implemenation 
 * 
 * @author Diego Pacheco
 * @version 1.0.GA
 * @since 04/05/2010
 * 
 */
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		return "Hello: " + name;
	}

}
