package com.github.diegopacheco.sandboxspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BadService {
    private final Logger LOG = LoggerFactory.getLogger(BadService.class);

    public void ok(){
        LOG.info("OK");
    }

    public void error(){
        LOG.error("error",new RuntimeException("error fake", new RuntimeException("Error fake root")));
    }

}
