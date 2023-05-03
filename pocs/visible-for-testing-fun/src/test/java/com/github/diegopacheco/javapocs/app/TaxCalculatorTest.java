package com.github.diegopacheco.javapocs.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void calculateRightTaxForRSIphone(){
        TaxCalculator tc = new TaxCalculator(12000D);
        Double price = tc.getPrice();
        assertEquals(12840D,price);
        assertEquals(TaxCalculator.State.RS,tc.getState());
    }

}
