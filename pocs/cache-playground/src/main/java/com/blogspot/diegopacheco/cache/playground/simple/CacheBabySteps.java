package com.blogspot.diegopacheco.cache.playground.simple;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class CacheBabySteps {
	
	private static final String CACHE_BOOKS_NAME = "CacheBook";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		CacheManager cm = CacheManager.create("src/main/resources/ehcache-simple.xml");
		cm.addCache(CACHE_BOOKS_NAME);
		
		Book b1 = new Book("The Holy Bible","God");
		Book b2 = new Book("The Da vince code","Dam Brown");
		Book b3 = new Book("Art of War","San Tzu");
		
		Element element1 = new Element(b1.getAuthor(), b1);
		Element element2 = new Element(b2.getAuthor(), b2);
		Element element3 = new Element(b3.getAuthor(), b3);
		
		Cache cache = cm.getCache(CACHE_BOOKS_NAME);
		cache.put(element1);
		cache.put(element2);
		cache.put(element3);
		
		List<Object> keys = cm.getCache(CACHE_BOOKS_NAME).getKeys();
		for(Object k: keys){
			System.out.println("Cache Key: " + k);
			Element e = cache.get(k);
			Object  o = e.getObjectValue();
			System.out.println("Cache Value: " + o);
		}	
		
		
		System.out.println("Simple statistics ");
		System.out.println("Memory cache: " + cache.getMemoryStoreSize());
		System.out.println("Memory hits : " + cache.getStatisticsAccuracy());
	}
}


