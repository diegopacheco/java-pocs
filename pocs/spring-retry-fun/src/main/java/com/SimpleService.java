package com;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
class SimpleService {
 
    @Retryable(Exception.class)
    public void service() {
        System.out.println("lets go");
        throw new RuntimeException("ops!");
    }
 
    @Recover
    public void recover(Exception e) {
        System.out.println("Recovero from: " + e.getMessage());
    }

}