package com.github.diegopacheco.design.patterns.structural.adapter;

import java.util.Properties;

// Adapter
public class PersistentConfigProviderAdapter implements PersistentConfigProvider{

    private ConfigProvider configProvider;

    public PersistentConfigProviderAdapter(ConfigProvider conf){
        this.configProvider = conf;
    }

    @Override
    public Properties getConfigs() {
        Properties prop = new Properties();

        for(String key : configProvider.getConfigs().keySet()){
            String value = configProvider.getConfigs().get(key);
            prop.put(key,value);
        }

        return prop;
    }
}
