import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.masterreplica.MasterReplica;
import io.lettuce.core.masterreplica.StatefulRedisMasterReplicaConnection;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ElastiCacheMasterReplicaMain {
    public static void main(String[] args) {

        RedisClient redisClient = RedisClient.create();

        // Syntax: redis://[password@]host[:port][/databaseNumber]
        List<RedisURI> nodes = Arrays.asList(RedisURI.create("redis://127.0.0.1:30003"),RedisURI.create("redis://127.0.0.1:30001"),RedisURI.create("redis://127.0.0.1:30002"));

        StatefulRedisMasterReplicaConnection<String, String> connection = MasterReplica.connect(redisClient, StringCodec.UTF8,nodes);
        connection.setReadFrom(ReadFrom.UPSTREAM_PREFERRED);
        System.out.println("Connected to Redis");

        System.out.println("Keys from Redis: " + connection.sync().keys("*"));

        connection.sync().set("key", "Hello, Redis! " + new Date());
        String value = connection.sync().get("key");
        System.out.println("Get from Redis: " + value);
        connection.sync().flushall();

        connection.close();
        redisClient.shutdown();
    }
}
