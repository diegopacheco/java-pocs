package com.blogspot.diegopacheco.cache.playground.cacheserver.rest;

import com.blogspot.diegopacheco.cache.playground.cacheserver.rest.core.HttpClientRESTBaby;
import com.blogspot.diegopacheco.cache.playground.cacheserver.rest.domain.People;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class MainRESTBabyRules {
	
	public static void main(String[] args) throws Throwable {
		
		HttpClientRESTBaby restBaby = new HttpClientRESTBaby();
		restBaby.createCache("cacheName1");
		restBaby.getCache("cacheName1");
		
		People p1 = new People();
		p1.setId(1l);
		p1.setName("Diego Pacheco");
		
		restBaby.addEntry("cacheName1", p1.getId().toString(), p1);
		
		String result = restBaby.getEntry("cacheName1", p1.getId().toString());
		
		People p2     = (People) new XStream().fromXML(result);
		System.out.println("P2: " + p2.toString());
		System.out.println("p1 is equals p2 ? " + p1.equals(p2)  );
		
	}
}

