package com.github.diegopacheco.pocs.java.junit5.tests;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeOutTest {

    @Test
    public void testWithTimeout(){
        System.out.println("Will wait 3s and give up.");
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            while (true);
        });
    }

}
