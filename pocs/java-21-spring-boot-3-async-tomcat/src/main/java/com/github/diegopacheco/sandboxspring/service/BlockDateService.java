package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlockDateService {

    public String getDateBlock() {
        // Simulate a long-running task
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new Date().toString();
    }
}