package com.github.diegopacheco.javapocs.calculator.v1;

import org.junit.jupiter.api.Test;

public class CalculatorV1Tests {

    @Test
    public void testSum(){
        CalculatorV1 calc = new CalculatorV1();
        assert calc.sum(1,1) == 2;
    }

    @Test
    public void testSub(){
        CalculatorV1 calc = new CalculatorV1();
        assert calc.sub(1,1) == 0;
    }

    @Test
    public void testMult(){
        CalculatorV1 calc = new CalculatorV1();
        assert calc.mult(2,2) == 4;
    }

    @Test
    public void testDiv(){
        CalculatorV1 calc = new CalculatorV1();
        assert calc.div(4,2) == 2;
    }

}
