package com.github.diegopacheco.sandbox.java.service.test.v2x;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.diegopacheco.sandbox.java.service.Version;
import com.github.diegopacheco.sandbox.java.service.test.DataServiceTestConfig;

public class DataServiceImplV2x {

	@Test	
	public void testWrongVersion(){
		assertThrows(IllegalArgumentException.class, ()->  
			DataServiceTestConfig.getDataService().getCurrentDate(null) );
	}
	
	@Test	
	public void test2xVersionOK(){
			String result = DataServiceTestConfig.getDataService().getCurrentDate(new Version("2.x"));
			assertNotNull(result);
			assertTrue(!"".equals(result));
	}
	
}
