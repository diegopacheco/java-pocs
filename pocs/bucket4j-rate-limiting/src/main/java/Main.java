import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;
import java.time.Duration;

public class Main{
  public static void main(String args[]){
    Bandwidth limit = Bandwidth.classic(10, Refill.intervally(10, Duration.ofSeconds(1)));
    Bucket bucket = Bucket.builder()
        .addLimit(limit)
        .build();

    System.out.println("Rate Limiting POC - 10 requests per second");

    for (int i = 1; i <= 15; i++) {
      if (bucket.tryConsume(1)) {
        System.out.println("Request " + i + ": ALLOWED");
      } else {
        System.out.println("Request " + i + ": RATE LIMITED");
      }
    }
  }
}
