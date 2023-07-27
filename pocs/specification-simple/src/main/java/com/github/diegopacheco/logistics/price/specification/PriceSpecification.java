package com.github.diegopacheco.logistics.price.specification;

import com.github.diegopacheco.logistics.price.PreOrder;

import java.math.BigDecimal;

public interface PriceSpecification {
    boolean isSatisfiedBy(int year,State state);
    BigDecimal getTax(State state);
}
