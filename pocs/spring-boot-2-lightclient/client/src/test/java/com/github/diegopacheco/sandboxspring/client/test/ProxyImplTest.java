package com.github.diegopacheco.sandboxspring.client.test;

import com.github.diegopacheco.sandboxspring.client.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyImplTest {

    @Test
    public void testMul(){
        Client client = Client.getInstance();
        Double result = client.mul(2D,3D);
        assertEquals(6D,result);
    }

    @Test
    public void testSum(){
        Client client = Client.getInstance();
        Double result = client.sum(4D,3D);
        assertEquals(7D,result);
    }

}
