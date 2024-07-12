package com.github.diegopacheco.sandboxspring.batch;

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

    public boolean generateUUID(){
        logger.info("UUIDBatchService running. Generating UUIDs...");
        service.generateUUIDs(10)
                .stream()
                .forEach(System.out::println);
        return true;
    }

}
