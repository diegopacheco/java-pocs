package com.github.diegopacheco.javapocs.suites;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumTests {

    @Test
    public void testSum(){
        Calculator calc = new Calculator(1,2);
        assertEquals(3,calc.sum());
    }

    @Test
    public void testSumZero(){
        Calculator calc = new Calculator(0,0);
        assertEquals(0,calc.sum());
    }

}
