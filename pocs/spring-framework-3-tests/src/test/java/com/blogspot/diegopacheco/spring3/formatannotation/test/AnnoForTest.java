package com.blogspot.diegopacheco.spring3.formatannotation.test;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blogspot.diegopacheco.spring3.formatannotation.MoedaBR;

public class AnnoForTest {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring3-annofor-beans.xml");
		MoedaBR mbr = (MoedaBR)ac.getBean("moedaBR");
		
		mbr.setValor(new BigDecimal("175629"));
		mbr.setPais("brasil");
		
		mbr.validate();
		
		System.out.println("moeda formatada:" + mbr.getValor());
		
	}
}
