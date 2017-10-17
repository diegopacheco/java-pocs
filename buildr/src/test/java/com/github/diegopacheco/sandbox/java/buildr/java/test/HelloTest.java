package com.github.diegopacheco.sandbox.java.buildr.java.test;

import junit.framework.Assert;
import org.junit.Test;
import com.github.diegopacheco.sandbox.java.buildr.java.Hello;

public class HelloTest {
	
	@Test
	public void testSayHello(){
		String result = Hello.sayHello();
		Assert.assertEquals("Hello World!", result);
	}
	
}
