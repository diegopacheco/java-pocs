import com.codahale.metrics.*;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.codahale.metrics.MetricRegistry.name;

public class Main{

  private final static MetricRegistry metrics = new MetricRegistry();
  private final static Meter requests = metrics.meter("requests");
  private final static Counter counter = metrics.counter("counter");
  private final static Gauge gauges = metrics.gauge("gauges");
  private final static Timer responses = metrics.timer(name(Main.class, "responses"));
  private final static HealthCheckRegistry healthChecks = new HealthCheckRegistry();

  public static class HealthChecker extends HealthCheck {
    public HealthChecker() { }
    @Override
    public HealthCheck.Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }
  }

  public static void main(String[] args){

    ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    reporter.start(3, TimeUnit.SECONDS);

    healthChecks.register("app",new HealthChecker());

    requests.mark();
    requests.mark();
    counter.inc();
    gauges.getValue();

    try(final Timer.Context context = responses.time()) {
      wait5Seconds();
    };

    wait5Seconds();
    requests.mark();
    counter.inc();
    gauges.getValue();

    wait5Seconds();
    wait5Seconds();

    final Map<String, HealthCheck.Result> results = healthChecks.runHealthChecks();
    for (Map.Entry<String, HealthCheck.Result> entry : results.entrySet()) {
      if (entry.getValue().isHealthy()) {
        System.out.println(entry.getKey() + " is healthy");
      } else {
        System.err.println(entry.getKey() + " is UNHEALTHY: " + entry.getValue().getMessage());
        final Throwable e = entry.getValue().getError();
        if (e != null) {
          e.printStackTrace();
        }
      }
    }
  }

  static void wait5Seconds() {
    try {
      Thread.sleep(5*1000);
    }
    catch(InterruptedException e) {}
  }

}
