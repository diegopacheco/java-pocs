package com.github.diegopacheco.sandbox.java.truth.tests.simple;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TruthTestFun {
	
	@Test
	public void AssertionTests(){
		assertThat(5).isEqualTo(5);
	}
	
	@Test(expected=AssertionError.class)
	public void AssertionFailTests(){
		assertThat(6).isEqualTo(5);
	}
	
	@Test
	public void assertObjectsTest(){
		assertThat(new Object()).isNotNull();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAlotOfStuff(){
		assertThat(Arrays.asList(new String[]{"a"})).contains("a");  
		
		Map aMap = new HashMap<>();
		aMap.put("foo", "bar");
		assertThat(aMap).containsKey("foo");  
	}
	
}
