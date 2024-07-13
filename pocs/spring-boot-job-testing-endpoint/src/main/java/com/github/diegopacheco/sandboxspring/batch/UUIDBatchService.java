package com.github.diegopacheco.sandboxspring.batch;

import com.github.diegopacheco.sandboxspring.config.TestingFlagManager;
import com.github.diegopacheco.sandboxspring.service.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UUIDBatchService {

    private Logger logger = LoggerFactory.getLogger(UUIDBatchService.class);

    @Autowired
    private UUIDGenerator service;

    @Autowired
    private TestingFlagManager ffm;

    public boolean generateUUID(){
        logger.info("UUIDBatchService running. Generating UUIDs...");

        int amount = 10;
        if (ffm.isNonProd()){
            amount = ffm.getAmount();
            logger.info("Running in non-prod mode. Amount: " + amount);
        }

        service.generateUUIDs(amount)
                .stream()
                .forEach(System.out::println);
        return true;
    }

}
