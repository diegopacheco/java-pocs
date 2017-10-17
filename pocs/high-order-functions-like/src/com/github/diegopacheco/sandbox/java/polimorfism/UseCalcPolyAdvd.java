package com.github.diegopacheco.sandbox.java.polimorfism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseCalcPolyAdvd {
	
	public interface Operation<T,I1,I2,O> {
		public O func(T t,I1 i1,I2 i2);
	}
	
	public static Operation<String,Number, Number,Number> add = new Operation<String,Number, Number, Number>() {		
		@Override
		public Number func(String t,Number i1, Number i2) {
			return "add".equals(t) ? new Double(i1.doubleValue() + i2.doubleValue()) : null;
		}
	};
	
	public static Operation<String,Number, Number,Number> sub = new Operation<String,Number, Number, Number>() {		
		@Override
		public Number func(String t,Number i1, Number i2) {
			return "sub".equals(t) ? new Double(i1.doubleValue() - i2.doubleValue()) : null;
		}
	};
	
	public static Operation<String,Number, Number,Number> div = new Operation<String,Number, Number, Number>() {		
		@Override
		public Number func(String t,Number i1, Number i2) {
			return "div".equals(t) ? new Double(i1.doubleValue() / i2.doubleValue()) : null;
		}
	};
	
	public static Operation<String,Number, Number,Number> mul = new Operation<String,Number, Number, Number>() {		
		@Override
		public Number func(String t,Number i1, Number i2) {
			return new Double(i1.doubleValue() * i2.doubleValue());
		}
	};
	
	public static void main(String[] args) {

		List<Operation<String,Number, Number, Number>> ops = new ArrayList<Operation<String,Number,Number,Number>>();
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

		for (Operation<String,Number, Number, Number> o: ops) {
			for(String key: dados.keySet()){
				System.out.println(o.func(key, dados.get(key).get(0) , dados.get(key).get(1)));
			}			
		}
		
	}
}