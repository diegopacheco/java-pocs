package com.github.diegopacheco.logistics.price;

import com.github.diegopacheco.logistics.price.specification.PriceSpecification;
import com.github.diegopacheco.logistics.price.specification.State;

import java.math.BigDecimal;

public class PriceSimulationService implements PriceSimulation {
    @Override
    public BigDecimal simulate(PreOrder preorder) {
        PriceSpecification priceSpecification = PriceSimulationFactory.build(2023);
        State state = preorder.getDestinationState();

        BigDecimal total = preorder.getTotal();
        BigDecimal taxState = priceSpecification.getTax(state);
        BigDecimal taxTotal = total.multiply(taxState.divide(new BigDecimal(100)));
        BigDecimal totalPlusTax = total.add(taxTotal);
        return totalPlusTax;
    }
}
