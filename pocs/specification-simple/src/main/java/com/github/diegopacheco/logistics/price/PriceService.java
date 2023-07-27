package com.github.diegopacheco.logistics.price;

import java.math.BigDecimal;

public interface PriceService {
    BigDecimal simulate(Order order);
}
