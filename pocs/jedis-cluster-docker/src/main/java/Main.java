import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class Main{

  private static final JedisCluster jedisCluster;

  static{
    synchronized (Main.class){
      Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6371));
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6372));
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6373));
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6374));
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6375));
      jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6376));
      jedisCluster = new JedisCluster(jedisClusterNodes,null,"bitnami");
    }
  }

  public static void main(String args[]){
      jedisCluster.set("x","value_x");
      System.out.println(jedisCluster.get("x"));
  }
}
