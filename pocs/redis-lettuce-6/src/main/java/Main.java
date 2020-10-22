import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class Main{
  public static void main(String args[]){

    RedisClient redisClient = RedisClient.create("redis://localhost:6379/");
    StatefulRedisConnection<String, String> connection = redisClient.connect();
    RedisCommands<String, String> syncCommands = connection.sync();
    syncCommands.set("key", "Hello, Redis!");
    String value = syncCommands.get("key");
    System.out.println("Get from Redis: " + value);

  }
}
