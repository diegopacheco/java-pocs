package com.github.diegopacheco.sandbox.java.spring4.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SimpleApplication {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService hs = (HelloService) ac.getBean("helloService");
		hs.printHello();
		((AnnotationConfigApplicationContext)ac).close();
	}
}
