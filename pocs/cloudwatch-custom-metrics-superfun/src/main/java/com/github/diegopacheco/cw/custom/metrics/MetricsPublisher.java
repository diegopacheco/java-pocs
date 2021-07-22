package com.github.diegopacheco.cw.custom.metrics;

import java.util.Map;

public interface MetricsPublisher{
    int publish(String name,Double value,Map<String,String> tags);
}
