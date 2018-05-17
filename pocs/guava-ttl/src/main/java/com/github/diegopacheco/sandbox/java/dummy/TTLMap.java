package com.github.diegopacheco.sandbox.java.dummy;

import java.util.function.Supplier;

/**
 * TTLMap is half/map like capability. I did not extend map because there is 1k lines of code there and I just want to express one simple idea. :D
 * 
 * @author diegopacheco
 *
 * @param <K> generic key
 * @param <V> generic value
 */
public interface TTLMap<K,V> {
	
	public void put(K key,V value);
	
	public V get(K key);
	
	public V get(K key,Supplier<V> fallback);
	
	public V delete(K key);
	
}
