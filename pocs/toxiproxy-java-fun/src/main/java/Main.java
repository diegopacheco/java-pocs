import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Date;

public class Main{
  public static void main(String args[]){
    RedisClient client = RedisClient.create("redis://localhost:26379");
    StatefulRedisConnection<String, String> connection = client.connect();
    RedisCommands<String, String> commands = connection.sync();
    System.out.println("Connected to redis: redis://localhost:26379 via toxiproxy");

    while(true){
      try{
        String value = commands.set("k1", new Date().toString());
        String result = commands.get("k1");
        System.out.println("SET: " + value + " - GET: " + result);
        //Thread.sleep(1000L);
      }catch(Exception e){
        throw new RuntimeException(e);
      }
    }

  }
}
