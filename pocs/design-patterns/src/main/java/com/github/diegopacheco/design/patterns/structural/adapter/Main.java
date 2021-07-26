package com.github.diegopacheco.design.patterns.structural.adapter;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        ConfigProvider provider = new ConcurrentConfigProvider();
        PersistentConfigProvider adapter = new PersistentConfigProviderAdapter(provider);
        Properties configs = adapter.getConfigs();
        System.out.println(configs);
    }
}
