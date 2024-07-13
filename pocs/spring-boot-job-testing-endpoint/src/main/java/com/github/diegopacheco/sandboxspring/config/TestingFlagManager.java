package com.github.diegopacheco.sandboxspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestingFlagManager {

    @Value("#{environment.getActiveProfiles()[0]}")
    private String activeProfile;

    private int amount = 10;

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
