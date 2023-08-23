package com.github.diegopacheco.hamcrest.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberMatchersTest {
    @Test
    public void greaterThanTest() {
        assertThat(5, greaterThanOrEqualTo(5));
    }

    @Test
    public void lessThanTest() {
        assertThat(-1, lessThan(0));
    }

    @Test
    public void lessThanOrEqualToTest() {
        assertThat(-1, lessThanOrEqualTo(5));
    }

    @Test
    public void closeTest() {
        assertThat(1.2, closeTo(1, 0.5));
    }

}
