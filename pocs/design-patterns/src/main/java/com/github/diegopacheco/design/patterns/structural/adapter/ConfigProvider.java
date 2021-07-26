package com.github.diegopacheco.design.patterns.structural.adapter;

import java.util.Map;

public interface ConfigProvider {
    Map<String,String> getConfigs();
}
