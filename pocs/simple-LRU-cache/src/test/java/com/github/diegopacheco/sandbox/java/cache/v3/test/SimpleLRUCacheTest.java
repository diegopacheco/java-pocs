package com.github.diegopacheco.sandbox.java.cache.v3.test;

import com.github.diegopacheco.sandbox.java.cache.v3.LRUCache;
import com.github.diegopacheco.sandbox.java.cache.v3.SimpleLRUCache;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleLRUCacheTest {

    @Test
    public void testLRU(){
        LRUCache<String> cache = new SimpleLRUCache<>();
        cache.put("g1","Sc2");
        cache.put("g2","D3");
        cache.put("g3","D2");
        assertNotNull(cache);

        assertEquals("D3",cache.get("g2").get());
        assertEquals("D2",cache.get("g3").get());
        assertEquals(Optional.empty(),cache.get("g1"));
        assertEquals(2,cache.size());
    }

}
