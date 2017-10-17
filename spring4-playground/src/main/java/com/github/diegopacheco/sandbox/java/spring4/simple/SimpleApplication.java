package com.github.diegopacheco.sandbox.java.spring4.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleApplication {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		HelloService hs = (HelloService) ac.getBean("helloService");
		hs.printHello();
		((ClassPathXmlApplicationContext)ac).close();
	}
}
