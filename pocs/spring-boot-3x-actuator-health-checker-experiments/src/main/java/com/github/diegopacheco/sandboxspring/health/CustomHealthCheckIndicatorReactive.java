package com.github.diegopacheco.sandboxspring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CustomHealthCheckIndicatorReactive implements ReactiveHealthIndicator {

    private boolean running = System.getProperty("health.running", "true").equals("true");

    @Override
    public Mono<Health> health() {
        if (running) {
            System.out.println("[HC6] Health checker custom UP and called... ");
            return Mono.just(Health.up().
                    withDetail("luckyNumber",42).
                    withDetail("bestTeam","Gremio").
                    withDetail("nonProd",true).
                    withDetail("reactive",true).
                    withDetail("EXECUTION_ID", UUID.randomUUID().toString()).
                    build());
        } else {
            System.out.println("[HC6] Health checker custom DOWN and called... ");
            return Mono.just(Health.down().build());
        }
    }

}