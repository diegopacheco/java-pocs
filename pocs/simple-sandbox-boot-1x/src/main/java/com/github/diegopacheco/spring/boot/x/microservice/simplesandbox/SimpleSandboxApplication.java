package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class SimpleSandboxApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(SimpleSandboxApplication.class, args);
	}

}
