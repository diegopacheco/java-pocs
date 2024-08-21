package com.github.diegopacheco.sandboxspring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * ❯ ./test.sh
 * HTTP/1.1 200 OK
 * Content-Type: application/vnd.spring-boot.actuator.v3+json
 * Content-Length: 478
 *
 * {"status":"UP","components":{"customHealthCheckIndicatorSlow":{"status":"UP","details":{"luckyNumber":42,"bestTeam":"Gremio","nonProd":true,"EXECUTION_ID":"be7cf294-6024-4d14-8d89-9e2555f65e05"}},"diskSpace":{"status":"UP","details":{"total":983358451712,"free":297020014592,"threshold":10485760,"path":"/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-health-checker-experiments/.","exists":true}},"ping":{"status":"UP"}}}
 * HC return in [5.26 seconds]
 * {
 *   "status": "UP",
 *   "components": {
 *     "customHealthCheckIndicatorSlow": {
 *       "status": "UP",
 *       "details": {
 *         "luckyNumber": 42,
 *         "bestTeam": "Gremio",
 *         "nonProd": true,
 *         "EXECUTION_ID": "515c9c7e-b96f-4dcf-99f2-a44c44b0783a"
 *       }
 *     },
 *     "diskSpace": {
 *       "status": "UP",
 *       "details": {
 *         "total": 983358451712,
 *         "free": 297020014592,
 *         "threshold": 10485760,
 *         "path": "/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-health-checker-experiments/.",
 *         "exists": true
 *       }
 *     },
 *     "ping": {
 *       "status": "UP"
 *     }
 *   }
 * }
 */
//@Component
public class CustomHealthCheckIndicatorSlow  implements HealthIndicator {

    private boolean running = System.getProperty("health.running", "true").equals("true");

    @Override
    public Health health() {
        if (running) {
            sleep();
            System.out.println("[HC4] Health checker custom UP and called... ");
            return Health.up().
                    withDetail("luckyNumber",42).
                    withDetail("bestTeam","Gremio").
                    withDetail("nonProd",true).
                    withDetail("EXECUTION_ID", UUID.randomUUID().toString()).
                    build();
        } else {
            System.out.println("[HC4] Health checker custom DOWN and called... ");
            return Health.down().build();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}