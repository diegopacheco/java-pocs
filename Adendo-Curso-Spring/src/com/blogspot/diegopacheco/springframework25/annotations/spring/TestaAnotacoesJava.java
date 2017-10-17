package com.blogspot.diegopacheco.springframework25.annotations.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestaAnotacoesJava {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-annotation*.xml");
		ctx.getBean("anotacoesJava");		
		ctx.registerShutdownHook();

	}
}
