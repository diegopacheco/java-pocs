package com.blogspot.diegopacheco.spring3.spel.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blogspot.diegopacheco.spring3.spel.Pessoa;
import com.blogspot.diegopacheco.spring3.spel.PojoAnnotationsSpel;

public class TestaSpelNoXML {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PojoAnnotationsSpel.class);
		//ctx.scan("com.blogspot.diegopacheco");
		
		PojoAnnotationsSpel pas = ctx.getBean(PojoAnnotationsSpel.class);
		System.out.println(pas);
		
		System.out.println("pessoa " + ctx.getBean(Pessoa.class) );
	}
}