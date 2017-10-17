package com.blogspot.diegopacheco.spring3.spel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blogspot.diegopacheco.spring3.spel.PojoAnnotationsSpel;

public class TestaSpel {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring3-spel-beans.xml");
		PojoAnnotationsSpel ase = (PojoAnnotationsSpel)ac.getBean("configBean");
		System.out.println( ase );
		
	}
}
