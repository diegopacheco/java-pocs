package com.github.diegopacheco.sandbox.java.polimorfism;

public interface Operation<I1,I2,O> {
	public O func(I1 i1,I2 i2);
}
