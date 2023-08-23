package com.github.diegopacheco.hamcrest.test;

import com.github.diegopacheco.hamcrest.matcher.IsOddMatcher;
import com.github.diegopacheco.hamcrest.matcher.IsEvenMatcher;
import org.junit.jupiter.api.Test;

import static com.github.diegopacheco.hamcrest.matcher.IsEvenMatcher.isEvenMatcher;
import static com.github.diegopacheco.hamcrest.matcher.IsOddMatcher.isOddMatcher;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomMatchersTest {

    @Test
    public void isOddTest() {
        int num = 1;
        assertThat(num, isOddMatcher());
    }

    @Test
    public void isEvenTest() {
        int num = 2;
        assertThat(num, isEvenMatcher());
    }

}
