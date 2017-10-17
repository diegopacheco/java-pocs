package com.blogspot.diegopacheco.terracota.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blogspot.diegopacheco.terracota.service.TurmaService;

public class Bootstraping {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-terracota-beans.xml");
		
		TurmaService ts = (TurmaService) ac.getBean("turmaService");
		
		ts.adicionarDezMilAlunos();
		
		ts.mostrarAlunoN1();		
		
	}
}
