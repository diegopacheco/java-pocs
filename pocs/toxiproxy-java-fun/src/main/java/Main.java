import eu.rekawek.toxiproxy.Proxy;
import eu.rekawek.toxiproxy.ToxiproxyClient;
import eu.rekawek.toxiproxy.model.ToxicDirection;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Date;

public class Main{
  public static void main(String args[]){

    Proxy redisProxy = setupChaos();
    RedisCommands<String, String> commands = setUpRedisConnection();

    int i = 0;
    while(true){
      try{

        String value = commands.set("k1", new Date().toString());
        String result = commands.get("k1");
        System.out.println("SET: " + value + " - GET: " + result + " + i=="+i);
        i += 1;
        //Thread.sleep(1000L);

        if (10==i){
          cleanUpChaos(redisProxy);
        }

      }catch(Exception e){
        throw new RuntimeException(e);
      }
    }
  }

  private static Proxy setupChaos(){
    try{
      ToxiproxyClient client = new ToxiproxyClient("127.0.0.1", 8474);
      Proxy redisProxy = client.createProxy("redis", "127.0.0.1:26379", "127.0.0.1:6379");
      redisProxy.toxics().latency("1s-latency-toxic", ToxicDirection.DOWNSTREAM, 1000).setJitter(0);
      System.out.println("Redis Chaos Setup Done. ");
      System.out.println(" * 1s latency per ops added. ");
      return redisProxy;
    }catch(Exception e){
      System.out.println(e);
      throw new RuntimeException(e);
    }
  }

  private static void cleanUpChaos(Proxy proxy){
    try{
      System.out.println(" ToxiProxy clean up done.");
      proxy.delete();
      ToxiproxyClient client = new ToxiproxyClient("127.0.0.1", 8474);
      proxy = client.createProxy("redis", "127.0.0.1:26379", "127.0.0.1:6379");
    }catch(Exception e){
      System.out.println(e);
      throw new RuntimeException(e);
    }
  }

  private static RedisCommands<String, String> setUpRedisConnection(){
    RedisClient client = RedisClient.create("redis://localhost:26379");
    StatefulRedisConnection<String, String> connection = client.connect();
    RedisCommands<String, String> commands = connection.sync();
    System.out.println("Connected to redis: redis://localhost:26379 via toxiproxy");
    return commands;
  }

}
