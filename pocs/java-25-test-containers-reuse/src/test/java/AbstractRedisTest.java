import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public abstract class AbstractRedisTest {

    protected static final GenericContainer<?> REDIS_CONTAINER =
            new GenericContainer<>(
                    DockerImageName.parse("redis:7.4.2"))
                    .withExposedPorts(6379)
                    .withReuse(true);

    protected static JedisPool jedisPool;

    @BeforeAll
    static void startRedis() {
        REDIS_CONTAINER.start();
        String address = REDIS_CONTAINER.getHost();
        Integer port = REDIS_CONTAINER.getFirstMappedPort();
        jedisPool = new JedisPool(address, port);
    }

    protected Jedis getJedis() {
        return jedisPool.getResource();
    }
}
