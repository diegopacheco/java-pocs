package com.blogspot.diegopacheco.springframework25.testng;

import javax.annotation.PostConstruct;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups={"curso-spring"})
@ContextConfiguration(locations={"/spring-test-beans.xml"})
public class CalculadoraTest extends AbstractTestNGSpringContextTests {
	
	private Calculadora calc;
	
	private Double result;
	private ResultadoCallback callback; 
	
	@PostConstruct
	public void setup(){
		callback = new ResultadoCallback(){
			public void processar(Double resultado) {
				System.out.println("10/2 = " + resultado);
				result = resultado;
			}
		};
	}	
	
	public void testInjecaoSpring(){
		Assert.assertNotNull("A calculadora não foi injetada.",calc);
	}	

	@Timed(millis=3000)
	public void testCalculoDivisao(){				
		calc.dividir(10d, 2d, callback);
		Assert.assertEquals("Erro ao dividir 10/2.",5d, result);
	}
	
	@Test
	public void testExceptionDivisao(){
		calc.dividir(0d, 0d, callback);
		String nan = result.toString();
		if(!"NaN".equals(nan))
			Assert.fail();
		System.out.println("Execucao... ");
	}
	
	@Autowired
	@Test(enabled=false)
	public void setCalc(Calculadora calc) {
		this.calc = calc;
	}	
	
}
