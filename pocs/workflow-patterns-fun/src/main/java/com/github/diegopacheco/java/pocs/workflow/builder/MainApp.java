package com.github.diegopacheco.java.pocs.workflow.builder;

import com.github.diegopacheco.java.pocs.workflow.builder.tasks.BrewCoffee;
import com.github.diegopacheco.java.pocs.workflow.builder.tasks.GetWater;
import com.github.diegopacheco.java.pocs.workflow.builder.tasks.SelectCoffee;

public class MainApp {
    public static void main(String[] args) {

        // Run the whole workflow
        WorkflowEngine.Builder builder = new WorkflowEngine.Builder();
        builder.withInitialTask(new GetWater());
        builder.addTask(new SelectCoffee());
        builder.addTask(new BrewCoffee());
        WorkflowEngine engine = builder.build();

        Context ec = new Context();
        ec.set("COFFEE_TYPE","Mocha Blend");
        engine.execute(ec);

        // start from 2/3 of tasks
        ResumeFactory factory = new ResumeFactory();
        engine = factory.build(2);
        engine.execute(ec);
    }
}
