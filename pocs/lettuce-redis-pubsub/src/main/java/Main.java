import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.RedisPubSubListener;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;

public class Main{
  public static void main(String args[]){

    RedisClient client = RedisClient.create("redis://127.0.0.1:6379/0");
    StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
    connection.addListener(new RedisPubSubListener<String, String>(){
      @Override
      public void message(String s, String s2) {
        System.out.println("Got message: " + s + " " + s2);
      }
      @Override
      public void message(String s, String k1, String s2) {
        System.out.println("Got message: " + s + " " + k1 + " " + s2);
      }
      @Override
      public void subscribed(String s, long l) {}
      @Override
      public void psubscribed(String s, long l) {}
      @Override
      public void unsubscribed(String s, long l) {}
      @Override
      public void punsubscribed(String s, long l) {}
    });

    System.out.println("Up and running -- waiting for changes... ");
    System.out.println("do: $ echo 'PUBLISH channel Hello' | redis-cli");
    RedisPubSubCommands<String, String> sync = connection.sync();
    sync.subscribe("channel");

  }
}
