package com.github.diegopacheco.sandbox.java.awaitlity;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

import java.util.concurrent.Callable;

import org.awaitility.core.ConditionTimeoutException;
import org.junit.Test;

public class SimpleTests {
	
	private Callable<Boolean> customerStatusIsUpdated(){
		return new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return true;
			}
		};
	}
	
	@Test(expected=ConditionTimeoutException.class)
	public void updatesCustomerStatusError() throws Exception {
		// Awaitility lets you wait until the asynchronous operation completes:
		await().atMost(1, SECONDS).until(customerStatusIsUpdated());
	}
	
	@Test
	public void updatesCustomerStatusOK() throws Exception {
		// Awaitility lets you wait until the asynchronous operation completes:
		await().atMost(3, SECONDS).until(customerStatusIsUpdated());
	}


}
