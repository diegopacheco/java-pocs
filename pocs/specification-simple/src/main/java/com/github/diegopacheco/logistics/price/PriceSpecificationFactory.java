package com.github.diegopacheco.logistics.price;

import com.github.diegopacheco.logistics.price.specification.Price2022Specification;
import com.github.diegopacheco.logistics.price.specification.Price2023Specification;
import com.github.diegopacheco.logistics.price.specification.PriceSpecification;

public class PriceSpecificationFactory {

    public static PriceSpecification build(int year){
        if (2023==year){
            return new Price2023Specification();
        } else if (2022==year){
            return new Price2022Specification();
        }
        throw new IllegalArgumentException("Dont have price for year: " + year);
    }

}
