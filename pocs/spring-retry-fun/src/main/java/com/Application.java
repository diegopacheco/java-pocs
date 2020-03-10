package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
@SpringBootApplication
@ComponentScan(basePackages = "com")
public class Application implements CommandLineRunner {

    @Bean
    public SimpleService service() {
        return new SimpleService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service().service();
    
        RetryTemplate template = new RetryTemplate();
        TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(30000L);
        template.setRetryPolicy(policy);
        
        String result = template.execute(new RetryCallback<String,Exception>(){
            public String doWithRetry(RetryContext context) {
                return "Works";
            }
        }); 
        System.out.println("works: " + result);
    }

}