package com.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloClientTest {

    @Inject
    HelloClient client;

    @Test
    public void testHelloWorldResponse(){
        assertEquals("Hello World", client.hello().blockingGet());
    }
}
