import redis.clients.jedis.util.JedisClusterCRC16;

public class Main {

    private static String hashSlot(String key) {
        return JedisClusterCRC16.getCRC16(key) + "";
    }

    public static void main(String args[]) {
        System.out.println("test     = " + hashSlot("test"));
        System.out.println("mykey    = " + hashSlot("mykey"));
        System.out.println("{x}test  = " + hashSlot("{x}test"));
        System.out.println("{x}www   = " + hashSlot("{x}www"));
        System.out.println("{x}zzz   = " + hashSlot("{x}zzz"));
        System.out.println("x:test  = " + hashSlot("x:test"));
        System.out.println("x:www   = " + hashSlot("x:www"));
        System.out.println("x:zzz   = " + hashSlot("x:zzz"));
        System.out.println("y:test  = " + hashSlot("y:test"));
        System.out.println("y:www   = " + hashSlot("y:www"));
        System.out.println("y:zzz   = " + hashSlot("y:zzz"));
    }
}
