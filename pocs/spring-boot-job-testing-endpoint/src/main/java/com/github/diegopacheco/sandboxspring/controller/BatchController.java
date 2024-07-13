package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.batch.UUIDBatchService;
import com.github.diegopacheco.sandboxspring.config.TestingFlagManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/batch")
@Profile("!prod") // This controller is not active when the 'prod' profile is active
public class BatchController {

    private Logger logger = LoggerFactory.getLogger(BatchController.class);

    @Autowired
    private UUIDBatchService uuidBatchService;

    @Autowired
    private TestingFlagManager ffm;

    @GetMapping("/uuid/{amount}")
    public String taskUUIDGeneration(@PathVariable("amount") Integer amount) {
        if (null!=amount){
            logger.info("Setting amount to: " + amount);
            ffm.setAmount(amount);
        }
        return uuidBatchService.generateUUID() + "";
    }

}
