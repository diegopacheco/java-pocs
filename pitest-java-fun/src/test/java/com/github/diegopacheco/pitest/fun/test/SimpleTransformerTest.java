package com.github.diegopacheco.pitest.fun.test;

import org.junit.Test;

import com.github.diegopacheco.pitest.fun.SimpleTransformer;

import junit.framework.Assert;

public class SimpleTransformerTest {
	
	@Test
	public void testToNumber0(){
		SimpleTransformer st = new SimpleTransformer();
		int result = st.toNumber(0);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testToNumber1(){
		SimpleTransformer st = new SimpleTransformer();
		int result = st.toNumber(1);
		Assert.assertEquals(0, result);
	}
	
}
