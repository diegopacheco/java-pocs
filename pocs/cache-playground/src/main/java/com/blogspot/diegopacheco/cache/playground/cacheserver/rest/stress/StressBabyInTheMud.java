package com.blogspot.diegopacheco.cache.playground.cacheserver.rest.stress;

import com.blogspot.diegopacheco.cache.playground.cacheserver.rest.core.HttpClientRESTBaby;
import com.blogspot.diegopacheco.cache.playground.cacheserver.rest.domain.People;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Diego Pacheco
 *
 *
 * Time to Create cache is 767 ms
 * Time to Create[1000] objects is 6488 ms
 * Time to Read[1000] objects is 5947 ms
 *
 */
@SuppressWarnings("unused")
public class StressBabyInTheMud {
	
	public static final int MAX_NUM_STRESS_MSGS = 10000;
	
	private static final XStream xs = new XStream();
	
	public static void main(String[] args) throws Throwable{
		
		HttpClientRESTBaby restBaby = new HttpClientRESTBaby();
		restBaby.setMute(true);
		long initTime = 0;
		
		initTime = System.currentTimeMillis();
		restBaby.createCache("cacheNameStress");
		System.out.println("Time to Create cache is " + (System.currentTimeMillis()-initTime) + " ms"  );
		
		initTime = System.currentTimeMillis();
		for(int i = 0;i<MAX_NUM_STRESS_MSGS;i++){
			doStressWrite(restBaby,new Long(i));
		}		
		System.out.println("Time to Create[" + MAX_NUM_STRESS_MSGS + "] objects is " + (System.currentTimeMillis()-initTime) + " ms"  );
		
		initTime = System.currentTimeMillis();
		for(int i = 0;i<MAX_NUM_STRESS_MSGS;i++){
			doStressRead(restBaby,new Long(i));
		}
		System.out.println("Time to Read[" + MAX_NUM_STRESS_MSGS + "] objects is " + (System.currentTimeMillis()-initTime) + " ms"  );
		
	}
	
	private static void doStressWrite(HttpClientRESTBaby restBaby,Long id) throws Throwable{
		People px = new People();
		px.setId(id);
		px.setName("People: " + Math.random());
		
		restBaby.addEntry("cacheNameStress", px.getId().toString(), px);
	}
	
	public static void doStressRead(HttpClientRESTBaby restBaby,Long id)throws Throwable{
		String result = restBaby.getEntry("cacheNameStress", id.toString());
		People px     = (People)xs.fromXML(result);
	}
	
}
