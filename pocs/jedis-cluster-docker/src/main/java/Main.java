import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.ScanParams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final JedisCluster jedisCluster;

    static {
        synchronized (Main.class) {
            Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6371));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6372));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6373));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6374));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6375));
            jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6376));
            jedisCluster = new JedisCluster(jedisClusterNodes, null, "bitnami");
        }
    }

    private static void runStats() {
        System.out.println("*** Stats ");
        for (String key : Arrays.asList("192.168.32.2:6379", "192.168.32.3:6379", "192.168.32.4:6379",
                "192.168.32.5:6379", "192.168.32.6:6379", "192.168.32.7:6379")) {
            System.out.print("key : " + key + " - ");
            System.out.print(" max-total : "           + jedisCluster.getClusterNodes().get(key).getMaxTotal());
            System.out.print(" active : "              + jedisCluster.getClusterNodes().get(key).getNumActive());
            System.out.print(" mean-active-ms : "      + jedisCluster.getClusterNodes().get(key).getMeanActiveTimeMillis());
            System.out.print(" borrow : "              + jedisCluster.getClusterNodes().get(key).getBorrowedCount());
            System.out.print(" mean-borrow-wait-ms : " + jedisCluster.getClusterNodes().get(key).getMeanBorrowWaitTimeMillis());
            System.out.print(" max-wait-ms : "         + jedisCluster.getClusterNodes().get(key).getMaxWaitMillis());
            System.out.print("\n");
        }
        System.out.println("***");
    }

    private static void generateSetLoad(int amount) {
        ScanParams params = new ScanParams();
        for (int i = 0; i < amount; i++) {
            String uuid = UUID.randomUUID().toString();
            jedisCluster.set("x:x" + i + "-" + uuid, "value_x_" + i + "_" + uuid);
        }
    }

    private static void generateScanHeavyLoad(int amount) {
        ScanParams params = new ScanParams();
        for (int i = 0; i < amount; i++) {
            jedisCluster.scan("0",params.match("x*"));
        }
    }

    public static void main(String args[]) {
        Executors.newScheduledThreadPool(2).scheduleAtFixedRate(() -> {
            generateSetLoad(10_000);
            jedisCluster.get("x:x1");
        }, 0, 1, TimeUnit.SECONDS);

        Executors.newScheduledThreadPool(2).scheduleAtFixedRate(() -> {
            generateScanHeavyLoad(10_000);
        }, 0, 1, TimeUnit.SECONDS);

        Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(Main::runStats, 0, 5, TimeUnit.SECONDS);
    }
}
