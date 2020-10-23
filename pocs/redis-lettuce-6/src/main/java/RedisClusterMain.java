import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;

import java.util.Date;

public class RedisClusterMain {

    public static void main(String[] args) {
        RedisClusterClient redisClient = RedisClusterClient.create("redis://localhost:30001");
        StatefulRedisClusterConnection<String, String> connection = redisClient.connect();

        System.out.println("Keys from Redis: " + connection.sync().keys("*"));

        connection.sync().set("key", "Hello, Redis! " + new Date());
        String value = connection.sync().get("key");
        System.out.println("Get from Redis: " + value);

        connection.close();
        redisClient.shutdown();
    }

}
