package com.github.diegopacheco.hamcrest.matcher;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsOddMatcher extends TypeSafeMatcher<Integer> {

    public void describeTo(Description description) {
        description.appendText("a odd number");
    }

    @Factory
    public static Matcher<Integer> isOddMatcher() {
        return new IsOddMatcher();
    }

    @Override
    protected boolean matchesSafely(Integer integer) {
        return integer%2!=0;
    }

}
