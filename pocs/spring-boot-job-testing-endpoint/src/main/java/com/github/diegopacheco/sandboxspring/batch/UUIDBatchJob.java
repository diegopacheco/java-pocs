package com.github.diegopacheco.sandboxspring.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UUIDBatchJob {

    @Autowired
    private UUIDBatchService uuidBatchService;

    @Scheduled(cron = "0 1 0 * * ?") // Execute every day at 00:01
    public void task() {
        uuidBatchService.generateUUID();
    }

}
