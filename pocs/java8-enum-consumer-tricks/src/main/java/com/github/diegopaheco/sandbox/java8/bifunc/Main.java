package com.github.diegopaheco.sandbox.java8.bifunc;

public class Main {
	
	public static void main(String[] args) {
			
		 Calculator calc = new Calculator();
		 System.out.println("1 + 1 = " + calc.calc(1, 1, Math::sum));
		 System.out.println("1 - 1 = " + calc.calc(1, 1, Math::sub));
		 System.out.println("5 / 5 = " + calc.calc(5, 5, Math::div));
		 System.out.println("2 * 2 = " + calc.calc(2, 2, Math::mul));
		
	}
	
}
