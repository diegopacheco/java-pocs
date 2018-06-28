package com.example.mytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleTest {
	
	@Test
	public void testSum() {
		  boolean math = 2+2==4;
			assertEquals(true, math); 
	}
	
}
