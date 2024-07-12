package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.batch.UUIDBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/batch")
@Profile("!prod") // This controller is not active when the 'prod' profile is active
public class BatchController {

    @Autowired
    private UUIDBatchService uuidBatchService;

    @GetMapping("/uuid")
    public String taskUUIDGeneration() {
        return uuidBatchService.generateUUID() + "";
    }

}
