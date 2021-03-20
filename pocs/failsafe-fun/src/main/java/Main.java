import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import java.time.Duration;

public class Main{
  public static void main(String args[]){

    RetryPolicy<Object> retryPolicy = new RetryPolicy<>()
            .handle(RuntimeException.class)
            .withDelay(Duration.ofSeconds(2))
            .withMaxRetries(3);

    Failsafe.with(retryPolicy).run(() ->  {
      if ((Math.random()*10)<=6){
        throw new RuntimeException("random error");
      }
      System.out.println("OK");
    });
    System.out.println("DONE");
  }
}
