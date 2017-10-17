package com.blogspot.diegopacheco.springframework25.annotations.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestaInjecaoAnotacoes {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-annotation*.xml");
		Autor a =(Autor)ac.getBean("autor");
		System.out.println(a);
	}
}
