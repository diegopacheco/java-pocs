package com.github.diegopacheco.java.pocs.wrappers.test;

import com.github.diegopacheco.java.pocs.wrappers.BigInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigIntTest {

    @Test
    public void testAdd(){
        BigInt b1 = new BigInt("1000");
        BigInt b2 = new BigInt("2000");
        BigInt result = b1.plus(b2);

        System.out.println(b1.toString() + " + " + b2.toString() + " == " + result.toString());
        System.out.println("is possitive? " + result.isPositive());

        assertEquals("3000",result.getValue());
        assertEquals(true,result.isPositive());
    }

    @Test
    public void testMinus(){
        BigInt b1 = new BigInt("3002");
        BigInt b2 = new BigInt("2001");
        BigInt result = b1.minus(b2);

        System.out.println(b1.toString() + " - " + b2.toString() + " == " + result.toString());
        System.out.println("is possitive? " + result.isPositive());

        assertEquals("1001",result.getValue());
        assertEquals(true,result.isPositive());
    }

}
