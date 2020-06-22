package com.github.diegopacheco.sandboxspring.client.test;

import com.github.diegopacheco.sandboxspring.client.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyImplTest {

    @Test
    public void testMul(){
        Client client = Client.getInstance();
        Long start = System.currentTimeMillis();
        Double result = client.mul(2D,3D);
        Long end   = System.currentTimeMillis();
        assertEquals(6D,result);
        System.out.println("Mul(GET) execution time: " + (end-start) + " ms");
    }

    @Test
    public void testSum(){
        Client client = Client.getInstance();
        Long start = System.currentTimeMillis();
        Double result = client.sum(4D,3D);
        Long end   = System.currentTimeMillis();
        assertEquals(7D,result);
        System.out.println("Sum(POST) execution time: " + (end-start) + " ms");
    }

}
