package com.github.diegopacheco.design.patterns.behavioral.command;

public class DeployCommand implements Command {

    @Override
    public void execute(Object context) {
        // Do real deployment...
        System.out.println("Deploy app into kubernetes");
    }

    @Override
    public boolean shouldRun(Object context) {
        return context.toString().contains(".war");
    }
}
