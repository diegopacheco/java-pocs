package com.github.diegopacheco.sandboxspring.client.test;

import com.github.diegopacheco.sandboxspring.Application;
import com.github.diegopacheco.sandboxspring.client.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyImplTest {

    @BeforeAll
    public static void setup(){
        Application.main(new String[]{});
        // warmup
        Client client = Client.getInstance();
        for(int i=0;i<=10;i++){
            client.mul(2D,3D+i);
            client.sum(3D,7D+i);
        }
    }

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
