import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import static org.junit.jupiter.api.Assertions.*;

class RedisStringOperationsTest extends AbstractRedisTest {

    @AfterEach
    void cleanup() {
        try (Jedis jedis = getJedis()) {
            jedis.flushDB();
        }
    }

    @Test
    void testSetAndGet() {
        try (Jedis jedis = getJedis()) {
            jedis.set("key1", "value1");
            String result = jedis.get("key1");
            assertEquals("value1", result);
        }
    }

    @Test
    void testSetWithExpiration() throws InterruptedException {
        try (Jedis jedis = getJedis()) {
            jedis.setex("tempKey", 1, "tempValue");
            assertEquals("tempValue", jedis.get("tempKey"));
            Thread.sleep(1100);
            assertNull(jedis.get("tempKey"));
        }
    }

    @Test
    void testDelete() {
        try (Jedis jedis = getJedis()) {
            jedis.set("keyToDelete", "valueToDelete");
            assertTrue(jedis.exists("keyToDelete"));
            jedis.del("keyToDelete");
            assertFalse(jedis.exists("keyToDelete"));
        }
    }
}
