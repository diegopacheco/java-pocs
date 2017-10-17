package com.github.diegopacheco.sandbox.java.polimorfism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCalcPolyAdvdReflection {

	public interface Operation<I1,I2,O> {
		public O func(I1 i1,I2 i2);
	}
	
	public static Operation<Number, Number,Number> add = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() + i2.doubleValue());
		}
	};
	
	public static Operation<Number, Number,Number> sub = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() - i2.doubleValue());
		}
	};
	
	public static Operation<Number, Number,Number> mul = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() * i2.doubleValue());
		}
	};
	
	public static Operation<Number, Number,Number> div = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() / i2.doubleValue());
		}
	};
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<Operation<Number, Number, Number>> ops = new ArrayList<Operation<Number,Number,Number>>();
		ops.add(add);
		ops.add(sub);
		ops.add(div);
		ops.add(mul);	
		
		Map<String,List<Integer>> dados = new HashMap<String,List<Integer>>();
		dados.put("add", Arrays.asList(2,2));
		dados.put("sub", Arrays.asList(5,2));
		dados.put("mul", Arrays.asList(5,5));
		dados.put("div", Arrays.asList(10,2));
		dados.put("add", Arrays.asList(7,2));
		
		UseCalcPolyAdvdReflection instance = new UseCalcPolyAdvdReflection();
		
		for(String key: dados.keySet()){
			try {
				Operation<Number, Number,Number> oop = (Operation<Number, Number,Number>)
			        instance.getClass().getDeclaredField(key).get(instance);
				System.out.println( oop.func(dados.get(key).get(0), dados.get(key).get(1)) );
			} catch (Exception e) {
				throw new RuntimeException(e);
			}	
		}		
		
	}
	
}

