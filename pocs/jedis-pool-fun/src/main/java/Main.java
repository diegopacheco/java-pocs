import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPooled;

public class Main {
    public static void main(String args[]) {
        poolTryWithResource();
        poolNoTry();
        wrongLess();
        //wrong();
    }

    private static void wrong() {
        System.out.println("wrong");
        JedisPool pool = new JedisPool("localhost", 6379);
        for(int i=0;i<100;i++){
            Jedis jedis = pool.getResource();
            jedis.set("www" + i, "V" + i);
            System.out.println(jedis.get("www" + i));
        }
    }

    private static void wrongLess() {
        System.out.println("wrong");
        JedisPool pool = new JedisPool("localhost", 6379);
        for(int i=0;i<100;i++){
            try{
                Jedis jedis = pool.getResource();
                jedis.set("www" + i, "V" + i);
                System.out.println(jedis.get("www" + i));
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    private static void poolNoTry() {
        System.out.println("poolNoTry");
        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.set("www", "444");
            System.out.println(jedis.get("www"));
        }
        pool.close();
    }

    private static void poolTryWithResource(){
        System.out.println("poolTryWithResource");
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
