import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedisListOperationsTest extends AbstractRedisTest {

    @AfterEach
    void cleanup() {
        try (Jedis jedis = getJedis()) {
            jedis.flushDB();
        }
    }

    @Test
    void testListPushAndPop() {
        try (Jedis jedis = getJedis()) {
            jedis.lpush("tasks", "task1");
            jedis.lpush("tasks", "task2");
            jedis.lpush("tasks", "task3");

            assertEquals(3, jedis.llen("tasks"));
            assertEquals("task1", jedis.rpop("tasks"));
            assertEquals("task2", jedis.rpop("tasks"));
            assertEquals(1, jedis.llen("tasks"));
        }
    }

    @Test
    void testListRange() {
        try (Jedis jedis = getJedis()) {
            jedis.rpush("numbers", "1", "2", "3", "4", "5");

            List<String> all = jedis.lrange("numbers", 0, -1);
            assertEquals(5, all.size());
            assertEquals("1", all.get(0));
            assertEquals("5", all.get(4));

            List<String> partial = jedis.lrange("numbers", 1, 3);
            assertEquals(3, partial.size());
            assertEquals("2", partial.get(0));
            assertEquals("4", partial.get(2));
        }
    }

    @Test
    void testListIndex() {
        try (Jedis jedis = getJedis()) {
            jedis.rpush("items", "first", "second", "third");

            assertEquals("first", jedis.lindex("items", 0));
            assertEquals("second", jedis.lindex("items", 1));
            assertEquals("third", jedis.lindex("items", 2));

            jedis.lset("items", 1, "modified");
            assertEquals("modified", jedis.lindex("items", 1));
        }
    }
}
