package com.github.diegopacheco.hamcrest.test;

import com.github.diegopacheco.hamcrest.matcher.IsOddMatcher;
import com.github.diegopacheco.hamcrest.matcher.IsevenMatcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CustomMatchersTest {

    @Test
    public void isOddTest() {
        int num = 1;
        assertThat(num, new IsOddMatcher());
    }

    @Test
    public void isEvenTest() {
        int num = 2;
        assertThat(num, new IsevenMatcher());
    }

}
