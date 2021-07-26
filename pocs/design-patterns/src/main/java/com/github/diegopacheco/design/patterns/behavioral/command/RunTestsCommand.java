package com.github.diegopacheco.design.patterns.behavioral.command;

public class RunTestsCommand implements Command{
    @Override
    public void execute(Object context) {
        // do real JUnit test running...
        System.out.println("Running all junit tests... ");
    }

    @Override
    public boolean shouldRun(Object context) {
        return true;
    }
}
