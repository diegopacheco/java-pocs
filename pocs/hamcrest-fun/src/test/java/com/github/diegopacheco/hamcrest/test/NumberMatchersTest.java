package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

public class NumberMatchersTest {
    @Test
    public void greaterThanTest() {
        assertThat(5, greaterThanOrEqualTo(5));
    }

    @Test
    public void lessThanTest() {
        assertThat(-1, lessThan(0));
    }
    
}
