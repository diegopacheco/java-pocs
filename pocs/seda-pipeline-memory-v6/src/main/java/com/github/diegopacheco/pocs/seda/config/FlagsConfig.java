package com.github.diegopacheco.pocs.seda.config;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlagsConfig {

    @PostConstruct
    public void defaults(){
        FeatureFlagManager.set(FeatureFlagManager.QUEUE_SANITIZER_TIME_BACKPRESSURE_MS,0);
        FeatureFlagManager.set(FeatureFlagManager.QUEUE_CAT_TIME_BACKPRESSURE_MS,2);
        FeatureFlagManager.set(FeatureFlagManager.QUEUE_CONSOLE_TIME_BACKPRESSURE_MS,1);
    }

}
