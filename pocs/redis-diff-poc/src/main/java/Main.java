import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

import java.util.Set;

public class Main{
  public static void main(String args[]){

    RedisClient redisClient = RedisClient.create("redis://localhost:6379");
    StatefulRedisConnection<String, String> connection = redisClient.connect();

    long init = System.currentTimeMillis();

    long n = 1000000; // 1M
    for(long i=0;i<=n;i++){
       connection.sync().sadd("s1",i+"");
       if (i%2==0) connection.sync().sadd("s2",i+"");
    }

    long end = System.currentTimeMillis();
    System.out.println(n + " Insert time == " + (end-init) + " ms");

    init = System.currentTimeMillis();
    Set<String> delta = connection.sync().sdiff("s1","s2");
    System.out.println("Delta size: " + delta.size());
    System.out.println(n + " Delta time == " + (end-init) + " ms");

    connection.close();
    redisClient.shutdown();

  }
}
