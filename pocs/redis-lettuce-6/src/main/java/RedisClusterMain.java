import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;

public class RedisClusterMain {

    public static void main(String[] args) {
        RedisClusterClient redisClient = RedisClusterClient.create("redis://localhost:6379");
        StatefulRedisClusterConnection<String, String> connection = redisClient.connect();
        connection.sync().set("key", "Hello, Redis!");
        String value = connection.sync().get("key");
        System.out.println("Get from Redis: " + value);
    }

}
