import net.jodah.expiringmap.ExpiringMap;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main{
  public static void main(String args[]) throws InterruptedException {
    Map<String, Integer> map = ExpiringMap.builder()
            .maxSize(10)
            .expiration(5, TimeUnit.SECONDS)
            .build();

    // Expires after 5 seconds or as soon as a 10th element is added and this is the next one to expire based on the expiration policy
    map.put("universe", 42);

    System.out.println(map.get("universe"));
    Thread.sleep(5000L);
    System.out.println(map.get("universe"));
  }
}
