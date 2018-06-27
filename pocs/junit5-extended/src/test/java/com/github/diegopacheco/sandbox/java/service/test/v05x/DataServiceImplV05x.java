package com.github.diegopacheco.sandbox.java.service.test.v05x;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.github.diegopacheco.sandbox.java.service.Version;
import com.github.diegopacheco.sandbox.java.service.test.DataServiceTestConfig;

@Tag("v05x")
public class DataServiceImplV05x {

	@BeforeAll
	public static void setup() {
		 DataServiceTestConfig.setUp();
	}
	
	@Test	
	public void testWrongVersion(){
		assertThrows(RuntimeException.class, ()->  
			DataServiceTestConfig.getDataService().getCurrentDate(new Version("v05.x")) );
	}
	
}
