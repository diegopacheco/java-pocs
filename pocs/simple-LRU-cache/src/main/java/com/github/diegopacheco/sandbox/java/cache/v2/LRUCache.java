package com.github.diegopacheco.sandbox.java.cache.v2;

import java.util.Optional;

/**LRUCACHE contract
 *
 * WRITE based LRU
 * @param <T> generic type of Anything.
 *
 * @author Diego Pacheco
 */
public interface LRUCache<T> {
     public Optional<T> get(String key);
     public void set(String key,T value);
     public Integer size();
}
