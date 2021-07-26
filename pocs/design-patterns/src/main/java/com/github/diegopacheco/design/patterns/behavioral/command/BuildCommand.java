package com.github.diegopacheco.design.patterns.behavioral.command;

public class BuildCommand implements Command{
    @Override
    public void execute(Object context) {
        // do real maven compilation here...
        System.out.println("Building project with maven... ");
    }

    @Override
    public boolean shouldRun(Object context) {
        return true;
    }
}
