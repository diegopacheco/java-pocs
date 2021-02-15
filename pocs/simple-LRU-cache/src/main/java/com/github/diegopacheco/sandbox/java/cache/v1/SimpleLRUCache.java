package com.github.diegopacheco.sandbox.java.cache.v1;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SimpleLRUCache is a simple LRU cache impl with a ConcurrentHashMap and PriorityQueue as heap.
 * ReferenceEntry is used as container to track map and heap together.
 * Evictions are done in SET operations. Heap is refreshed in GET/SET Operations.
 *
 * @param <T> is any type.
 *
 * @author Diego Pacheco
 */
public class SimpleLRUCache<T> implements LRUCache<T>{

    private static final Integer THRESHOLD = 2;
    private Map<String,ReferenceEntry<T>>  cache = new ConcurrentHashMap<>();
    private PriorityQueue<ReferenceEntry<T>> lru = new PriorityQueue<>(new ReferenceEntry.ReferenceEntryMinComparator());
    LinkedList l = new LinkedList();


    public Optional<T> get(String key){
        ReferenceEntry<T> ref = cache.get(key);
        if (null==ref){
            return Optional.empty();
        }
        updateHeap(ref);
        return Optional.of( ref.getValue() );
    }

    @Override
    public void set(String key,T value){
        evictIfRequired();
        ReferenceEntry<T> ref = ReferenceEntry.from(key,value);
        cache.put(key,ref);
        updateHeap(ref);
    }

    private void updateHeap(ReferenceEntry<T> ref){
        lru.remove(ref);
        lru.add(ref);
    }

    private void evictIfRequired(){
        if (size()>=THRESHOLD){
            ReferenceEntry<T> ref = lru.poll();
            cache.remove(ref.getKey());
        }
    }

    @Override
    public Integer size() {
        return cache.size();
    }

}
