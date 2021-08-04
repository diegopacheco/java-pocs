import com.codahale.metrics.*;

import java.util.concurrent.TimeUnit;

public class Main{

  private final static MetricRegistry metrics = new MetricRegistry();
  private final static Meter requests = metrics.meter("requests");
  private final static Counter counter = metrics.counter("counter");
  private final static Gauge gauges = metrics.gauge("gauges");

  public static void main(String args[]){

    ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    reporter.start(3, TimeUnit.SECONDS);

    requests.mark();
    requests.mark();
    counter.inc();
    gauges.getValue();

    wait5Seconds();
    requests.mark();
    counter.inc();
    gauges.getValue();

    wait5Seconds();
    wait5Seconds();
  }

  static void wait5Seconds() {
    try {
      Thread.sleep(5*1000);
    }
    catch(InterruptedException e) {}
  }

}
