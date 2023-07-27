package com.github.diegopacheco.logistics.price;

import com.github.diegopacheco.logistics.price.specification.Price2023Specification;
import com.github.diegopacheco.logistics.price.specification.PriceSpecification;

public class PriceSimulationFactory {

    public static PriceSpecification build(int year){
        if (2023==year){
            return new Price2023Specification();
        }
        throw new IllegalArgumentException("Dont have price for year: " + year);
    }

}
