import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RedisHashOperationsTest extends AbstractRedisTest {

    @AfterEach
    void cleanup() {
        try (Jedis jedis = getJedis()) {
            jedis.flushDB();
        }
    }

    @Test
    void testHashSetAndGet() {
        try (Jedis jedis = getJedis()) {
            jedis.hset("user:1", "name", "John");
            jedis.hset("user:1", "age", "30");

            assertEquals("John", jedis.hget("user:1", "name"));
            assertEquals("30", jedis.hget("user:1", "age"));
        }
    }

    @Test
    void testHashMultipleFields() {
        try (Jedis jedis = getJedis()) {
            Map<String, String> userMap = new HashMap<>();
            userMap.put("name", "Alice");
            userMap.put("email", "alice@test.com");
            userMap.put("age", "25");

            jedis.hset("user:2", userMap);

            Map<String, String> result = jedis.hgetAll("user:2");
            assertEquals(3, result.size());
            assertEquals("Alice", result.get("name"));
            assertEquals("alice@test.com", result.get("email"));
            assertEquals("25", result.get("age"));
        }
    }

    @Test
    void testHashDelete() {
        try (Jedis jedis = getJedis()) {
            jedis.hset("user:3", "name", "Bob");
            jedis.hset("user:3", "age", "35");

            assertEquals(2, jedis.hlen("user:3"));
            jedis.hdel("user:3", "age");
            assertEquals(1, jedis.hlen("user:3"));
            assertNull(jedis.hget("user:3", "age"));
        }
    }
}
