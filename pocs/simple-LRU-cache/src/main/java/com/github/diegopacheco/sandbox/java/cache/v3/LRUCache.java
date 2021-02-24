package com.github.diegopacheco.sandbox.java.cache.v3;

import java.util.Optional;

/**LRU CACHE contract
 *
 * WRITE based LRU
 * @param <T> generic type of Anything.
 *
 * @author Diego Pacheco
 */
public interface LRUCache<T> {
     public Optional<T> get(String key);
     public void put(String key, T value);
     public Integer size();
}
