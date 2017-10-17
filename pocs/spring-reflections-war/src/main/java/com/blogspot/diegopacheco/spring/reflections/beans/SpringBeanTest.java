package com.blogspot.diegopacheco.spring.reflections.beans;

import com.blogspot.diegopacheco.spring.reflections.caller.SpringBeanReflectionCaller;

public class SpringBeanTest {
	
	private SpringBeanReflectionCaller sbrc;
	
	public void execute(){
		System.out.println("Executando metodo de bean do spring... ");
		
		Object result = sbrc.invokeSpring("simpleBusinessServiceImpl", "saveOrUpdate", "parametro1");
		System.out.println("Resultado da invovacao: " + result);
	}

	public void setSbrc(SpringBeanReflectionCaller sbrc) {
		this.sbrc = sbrc;
	}	
}
