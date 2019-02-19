package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthChecker {
	
	public Health health() {
		int errorCode = check(); 
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

	public int check() {
		return 0;
	}

}
