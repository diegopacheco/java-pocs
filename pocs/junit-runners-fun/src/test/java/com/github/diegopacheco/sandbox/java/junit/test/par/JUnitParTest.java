package com.github.diegopacheco.sandbox.java.junit.test.par;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class JUnitParTest {

	private String k;
	private String m;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
              { "message", "Hi It Works" }  
           });
    }
	
	public JUnitParTest(String key,String message) {
		m = message;
		k = key;
	}
	
	@Test
	public void testConstructorParamValidation() {
		Assert.assertEquals(k, "message");
		Assert.assertEquals(m, "Hi It Works");
	}

}
