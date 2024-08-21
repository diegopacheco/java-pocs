package com.github.diegopacheco.sandboxspring.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * ❯ ./test.sh
 * HTTP/1.1 200 OK
 * Content-Type: application/vnd.spring-boot.actuator.v3+json
 * Content-Length: 418
 *
 * {"status":"UP","components":{"customHealthCheckDetails":{"status":"UP","details":{"luckyNumber":42,"bestTeam":"Gremio","nonProd":true}},"diskSpace":{"status":"UP","details":{"total":983358451712,"free":297020026880,"threshold":10485760,"path":"/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-health-checker-experiments/.","exists":true}},"ping":{"status":"UP"}}}
 * HC return in [0.26 seconds]
 * {
 *   "status": "UP",
 *   "components": {
 *     "customHealthCheckDetails": {
 *       "status": "UP",
 *       "details": {
 *         "luckyNumber": 42,
 *         "bestTeam": "Gremio",
 *         "nonProd": true
 *       }
 *     },
 *     "diskSpace": {
 *       "status": "UP",
 *       "details": {
 *         "total": 983358451712,
 *         "free": 297020026880,
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
public class CustomHealthCheckDetails extends AbstractHealthIndicator {

    private boolean running = System.getProperty("health.running", "true").equals("true");

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (running) {
            System.out.println("[HC2] Health checker custom UP and called... ");
            builder.
                    up().
                    withDetail("luckyNumber",42).
                    withDetail("bestTeam","Gremio").
                    withDetail("nonProd",true).build();
        } else {
            System.out.println("[HC2] Health checker custom DOWN and called... ");
            builder.down().build();
        }
    }

}