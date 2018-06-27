package com.github.diegopacheco.sandbox.java.service.test;

import com.github.diegopacheco.sandbox.java.service.DataService;
import com.github.diegopacheco.sandbox.java.service.DataServiceImpl;

/**
 * Everything that needs to be reused goes here. No Asserts here.
 * @author diego
 *
 */
public final class DataServiceTestConfig {
		
		public static DataService getDataService() {
			 return new DataServiceImpl();
		}
		
}
