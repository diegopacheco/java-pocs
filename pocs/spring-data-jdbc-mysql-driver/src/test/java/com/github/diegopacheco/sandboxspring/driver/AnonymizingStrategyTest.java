package com.github.diegopacheco.sandboxspring.driver;

import org.junit.jupiter.api.Test;

public class AnonymizingStrategyTest {

    @Test
    public void testStarApplication(){
        AnonymizingStrategy strategy = AnonymizingStrategy.STAR;
        String result = strategy.getApplication().execute("1234567890");
        assert result.equals("**********");
    }

    @Test
    public void testLast4Application(){
        AnonymizingStrategy strategy = AnonymizingStrategy.LAST4;
        String result = strategy.getApplication().execute("1234567890");
        assert result.equals("******7890");
    }

    @Test
    public void testEmptyApplication(){
        AnonymizingStrategy strategy = AnonymizingStrategy.EMPTY;
        String result = strategy.getApplication().execute("1234567890");
        assert result.isEmpty();
    }

    @Test
    public void testNullApplication(){
        AnonymizingStrategy strategy = AnonymizingStrategy.NULL;
        String result = strategy.getApplication().execute("1234567890");
        assert result==null;
    }

}
