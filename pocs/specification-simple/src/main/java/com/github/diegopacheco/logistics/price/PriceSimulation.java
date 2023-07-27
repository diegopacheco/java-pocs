package com.github.diegopacheco.logistics.price;

import java.math.BigDecimal;

public interface PriceSimulation {
    BigDecimal simulate(PreOrder order);
}
