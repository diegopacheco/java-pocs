import redis.clients.jedis.JedisPooled;

public class Main {
    public static void main(String args[]) {
        poolTryWithResource();
    }

    private static void poolTryWithResource(){
        try (JedisPooled pool = new JedisPooled("localhost", 6379)) {
            pool.set("x", "10");
            pool.set("y", "20");
            pool.set("z", "30");
        }
        try (JedisPooled pool = new JedisPooled("localhost", 6379)) {
            System.out.println(pool.get("x"));
            System.out.println(pool.get("y"));
            System.out.println(pool.get("z"));
        }
    }

}
