package com.blogspot.diegopacheco.spring.bootstrap.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
