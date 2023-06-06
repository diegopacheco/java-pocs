package com.github.diegopacheco.java.pocs.workflow.chain;

import com.github.diegopacheco.java.pocs.workflow.chain.tasks.BrewCoffee;

public class MainApp {
    public static void main(String[] args) {

        // Run the whole workflow
        WorkflowEngine engine = new WorkflowEngine();
        Context ec = new Context();
        ec.set("COFFEE_TYPE","Mocha Blend");
        engine.execute(ec);

        // start from 2/3 of tasks
        engine = new WorkflowEngine(new BrewCoffee());
        ec = new Context();
        engine.execute(ec);
    }
}
