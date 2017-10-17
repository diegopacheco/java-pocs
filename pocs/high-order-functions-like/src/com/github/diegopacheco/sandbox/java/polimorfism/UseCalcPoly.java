package com.github.diegopacheco.sandbox.java.polimorfism;

import static com.github.diegopacheco.sandbox.java.polimorfism.CalcPloly.add;
import static com.github.diegopacheco.sandbox.java.polimorfism.CalcPloly.div;
import static com.github.diegopacheco.sandbox.java.polimorfism.CalcPloly.mul;
import static com.github.diegopacheco.sandbox.java.polimorfism.CalcPloly.sub;

import java.util.ArrayList;
import java.util.List;

public class UseCalcPoly {
	public static void main(String[] args) {
		
		System.out.println("--------");
		System.out.println(add.func(2, 2));
		System.out.println(div.func(2, 2));
		System.out.println(sub.func(2, 2));
		System.out.println(mul.func(2, 2));		
		System.out.println("--------");
		
		List<Operation<Number, Number, Number>> ops = new ArrayList<Operation<Number,Number,Number>>();
		ops.add(add);
		ops.add(sub);
		ops.add(div);
		ops.add(mul);
		
		for (Operation<Number, Number, Number> o: ops) {
			System.out.println(o.func(2, 2));
		}	
		
	}
}
