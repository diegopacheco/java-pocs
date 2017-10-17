package com.blogspot.diegopacheco.spring.reflections.beans;

public class SimpleBusinessServiceImpl implements BusinessService {

	private static final long serialVersionUID = 1L;

	@Override
	public Object saveOrUpdate(String name) {		
		Object result = new String(name + " modificado.");
		System.out.println("Persistence call ok!");
		return result;
	}
	
}
