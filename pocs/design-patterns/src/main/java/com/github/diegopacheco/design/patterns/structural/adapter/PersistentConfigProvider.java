package com.github.diegopacheco.design.patterns.structural.adapter;

import java.util.Properties;

public interface PersistentConfigProvider {
    Properties getConfigs();
}
