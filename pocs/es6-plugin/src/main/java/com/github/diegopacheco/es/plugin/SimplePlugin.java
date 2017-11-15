package com.github.diegopacheco.es.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.plugins.Plugin;

public class SimplePlugin extends Plugin {
    private final static Logger LOGGER = LogManager.getLogger(SimplePlugin.class);
    
    public SimplePlugin() {
        super();
        LOGGER.info("ES Plugin Working by Diego!");
    }
}