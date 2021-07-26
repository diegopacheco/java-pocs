package com.github.diegopacheco.design.patterns.structural.adapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentConfigProvider implements ConfigProvider{
    @Override
    public Map<String, String> getConfigs() {
        Map<String,String> configs = new ConcurrentHashMap<>();
        configs.put("HOST","127.0.0.1");
        return configs;
    }
}
