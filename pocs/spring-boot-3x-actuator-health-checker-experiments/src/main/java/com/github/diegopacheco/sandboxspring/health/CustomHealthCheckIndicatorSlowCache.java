package com.github.diegopacheco.sandboxspring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * // first call no cache took 3.24 seconds
 *
 * ❯ ./test.sh
 * HTTP/1.1 200 OK
 * Content-Type: application/vnd.spring-boot.actuator.v3+json
 * Content-Length: 483
 *
 * {"status":"UP","components":{"customHealthCheckIndicatorSlowCache":{"status":"UP","details":{"luckyNumber":42,"bestTeam":"Gremio","EXECUTION_ID":"5b134f51-65cf-4d52-a0ad-defa6fda253b","nonProd":true}},"diskSpace":{"status":"UP","details":{"total":983358451712,"free":297019981824,"threshold":10485760,"path":"/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-health-checker-experiments/.","exists":true}},"ping":{"status":"UP"}}}
 * HC return in [3.24 seconds]
 * {
 *   "status": "UP",
 *   "components": {
 *     "customHealthCheckIndicatorSlowCache": {
 *       "status": "UP",
 *       "details": {
 *         "luckyNumber": 42,
 *         "bestTeam": "Gremio",
 *         "EXECUTION_ID": "5b134f51-65cf-4d52-a0ad-defa6fda253b",
 *         "nonProd": true
 *       }
 *     },
 *     "diskSpace": {
 *       "status": "UP",
 *       "details": {
 *         "total": 983358451712,
 *         "free": 297019981824,
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
 *
 * // second call cache took 0.01 seconds
 *
 * ❯ ./test.sh
 * HTTP/1.1 200 OK
 * Content-Type: application/vnd.spring-boot.actuator.v3+json
 * Content-Length: 483
 *
 * {"status":"UP","components":{"customHealthCheckIndicatorSlowCache":{"status":"UP","details":{"luckyNumber":42,"bestTeam":"Gremio","EXECUTION_ID":"5b134f51-65cf-4d52-a0ad-defa6fda253b","nonProd":true}},"diskSpace":{"status":"UP","details":{"total":983358451712,"free":297019981824,"threshold":10485760,"path":"/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/spring-boot-3x-actuator-health-checker-experiments/.","exists":true}},"ping":{"status":"UP"}}}
 * HC return in [0.01 seconds]
 * {
 *   "status": "UP",
 *   "components": {
 *     "customHealthCheckIndicatorSlowCache": {
 *       "status": "UP",
 *       "details": {
 *         "luckyNumber": 42,
 *         "bestTeam": "Gremio",
 *         "EXECUTION_ID": "5b134f51-65cf-4d52-a0ad-defa6fda253b",
 *         "nonProd": true
 *       }
 *     },
 *     "diskSpace": {
 *       "status": "UP",
 *       "details": {
 *         "total": 983358451712,
 *         "free": 297019981824,
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
 *
 */
//@Component
public class CustomHealthCheckIndicatorSlowCache implements HealthIndicator {

    private boolean running = System.getProperty("health.running", "true").equals("true");

    @Override
    @Cacheable("health")
    public Health health() {
        if (running) {
            sleep();
            System.out.println("[HC5] Health checker custom UP and called... ");
            return Health.
                    up().
                    withDetail("luckyNumber",42).
                    withDetail("bestTeam","Gremio").
                    withDetail("EXECUTION_ID", UUID.randomUUID().toString()).
                    withDetail("nonProd",true).build();
        } else {
            System.out.println("[HC5] Health checker custom DOWN and called... ");
            return Health.down().build();
        }
    }


    private void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}