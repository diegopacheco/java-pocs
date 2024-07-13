package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestingFlagManager implements EnvironmentAware {

    private String activeProfile;
    private int amount = 10;

    @Override
    public void setEnvironment(Environment environment) {
        String[] profiles = environment.getActiveProfiles();
        if (profiles.length > 0) {
            activeProfile = profiles[0];
        } else {
            activeProfile = "default";
        }
    }

    public boolean isNonProd() {
        return !"prod".equals(activeProfile);
    }

    public boolean isProd() {
        return "prod".equals(activeProfile);
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
