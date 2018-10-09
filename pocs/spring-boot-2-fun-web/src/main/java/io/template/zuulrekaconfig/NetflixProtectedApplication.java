package io.template.zuulrekaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NetflixProtectedApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixProtectedApplication.class, args);
    }
    
}