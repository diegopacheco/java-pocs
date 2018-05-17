package com.github.diegopacheco.sandbox.java.dummy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * ConcurrentTTLMap uses a internal concurrent hashmap and accepts TTL in MILLISECONDS; This map provides callback call right away after exprirations. <BR>
 * Both Reads and Write increment the TTL. Lack of any activity(R/W) that will decrement the TTL. Callback is called in SYNC fashion<BR><BR>
 * 
 * *NOTE*: sysout should be removed they are here just to show whats going on(as POC). <BR><BR>
 * 
 * This should not be used in production - guava is way more efficient.  <BR><BR>
 * 
 * TIME COMPLEXITY: <BR>
 *  TTL checks = o(N) but is on a background thread. <BR>
 *  R/W = is o(1).
 * 
 * @author diegopacheco
 *
 * @param <K> generic key
 * @param <V> generic value
 */
public class ConcurrentTTLMap<K,V> implements TTLMap<K,V>{
	
	/**
	 * Wrap any value that we might put on the map so this way we can control the TTL and evictions. Final user dont see this object(internal).
	 */
	private class TTLEntry{
			public K key;
			public V value;
			public long timestamp;
			public TTLEntry(K key, V value, long timestamp) {
				super();
				this.key = key;
				this.value = value;
				this.timestamp = timestamp;
			}
	}
	
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	private final Map<K,TTLEntry> internalMap = new ConcurrentHashMap<K,TTLEntry>();
	private BiConsumer<K, V> callback;
	private long ttl = 5000;
	private int checkerInterval = 1000;
	
	public ConcurrentTTLMap(long ttl,int checkerInterval, BiConsumer<K, V> callback) {
		super();
		this.ttl = ttl;
		this.callback = callback;
		this.checkerInterval = checkerInterval;
		registerBackgroundThread();
	}
	
	public ConcurrentTTLMap(BiConsumer<K, V> callback) {
		super();
		this.callback = callback;
		registerBackgroundThread();
	}
	
	private void registerBackgroundThread() {
		
		executor.scheduleAtFixedRate( () -> { 
			
			System.out.println("Checking TTL keys...");
			for(K key : internalMap.keySet() ) {
				TTLEntry entryValue = internalMap.get(key);
				if(entryValue!=null) {
					if (isTTLExpired(entryValue)) {
						System.out.println("Purging key[" + entryValue.key + "] ");
						delete(entryValue.key);
					}
				}
			}
			 
		},
		0, checkerInterval, TimeUnit.MILLISECONDS);
		
	}

	@Override
	public void put(K key, V value) {
		
		TTLEntry entry = internalMap.get(key);
		if (entry!=null) {
			entry.timestamp = System.currentTimeMillis();
			internalMap.put(key, entry);
		}else {
			entry = new TTLEntry(key,value,System.currentTimeMillis());
			internalMap.put(key, entry);
		}
		
	}

	@Override
	public V get(K key) {
		TTLEntry entry = internalMap.get(key);
		if (entry==null) 
			return null;
		
		V value = entry.value;
		if(value==null) {
			return null;
		}
		
		entry.timestamp=System.currentTimeMillis();
		internalMap.put(key, entry);
		return value;
	}

	@Override
	public V get(K key, Supplier<V> fallback) {
		TTLEntry entry = internalMap.get(key);
		if (entry==null) {
			V value = fallback.get();
			if(value!=null) {
				entry = new TTLEntry(key, value, System.currentTimeMillis());
				internalMap.put(key, entry);
			}
		}else {
			entry = new TTLEntry(key, entry.value, System.currentTimeMillis());
			internalMap.put(key, entry);
		}
		return (entry.value==null) ? fallback.get() : entry.value;
	}

	@Override
	public V delete(K key) {
		TTLEntry entry = internalMap.remove(key);
		if (entry==null) {
			return null;
		}else {
			callback.accept(entry.key, entry.value);
			return entry.value;
		}
	}
	
	private boolean isTTLExpired(TTLEntry entry) {
		 if (entry==null) 
			 return true;
		 
		 if ((System.currentTimeMillis() - entry.timestamp) > ttl) 
			 return true;
		 
		 return false;
	}
	
}
