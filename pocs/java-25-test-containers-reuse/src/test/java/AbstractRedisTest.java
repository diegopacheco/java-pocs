import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public abstract class AbstractRedisTest {

    private static final Logger log = LogManager.getLogger(AbstractRedisTest.class);

    protected static final GenericContainer<?> REDIS_CONTAINER =
            new GenericContainer<>(
                    DockerImageName.parse("redis:7.4.2"))
                    .withExposedPorts(6379)
                    .withReuse(true);

    protected static JedisPool jedisPool;

    @BeforeAll
    static void startRedis() {
        log.info("========================================");
        log.info("STARTING REDIS CONTAINER");
        log.info("Container ID: {}", REDIS_CONTAINER.getContainerId());
        log.info("Reuse enabled: {}", REDIS_CONTAINER.isShouldBeReused());
        log.info("========================================");

        REDIS_CONTAINER.start();

        log.info("========================================");
        log.info("REDIS CONTAINER STARTED");
        log.info("Container ID: {}", REDIS_CONTAINER.getContainerId());
        log.info("Running: {}", REDIS_CONTAINER.isRunning());
        log.info("========================================");

        String address = REDIS_CONTAINER.getHost();
        Integer port = REDIS_CONTAINER.getFirstMappedPort();
        jedisPool = new JedisPool(address, port);
    }

    protected Jedis getJedis() {
        return jedisPool.getResource();
    }
}
