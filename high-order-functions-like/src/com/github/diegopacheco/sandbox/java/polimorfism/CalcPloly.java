package com.github.diegopacheco.sandbox.java.polimorfism;

public class CalcPloly {
	
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
	
	public static Operation<Number, Number,Number> div = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() / i2.doubleValue());
		}
	};
	
	public static Operation<Number, Number,Number> mul = new Operation<Number, Number, Number>() {		
		@Override
		public Number func(Number i1, Number i2) {
			return new Double(i1.doubleValue() * i2.doubleValue());
		}
	};
	
}
