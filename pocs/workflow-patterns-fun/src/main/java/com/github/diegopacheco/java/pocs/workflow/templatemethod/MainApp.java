package com.github.diegopacheco.java.pocs.workflow.templatemethod;

import com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks.BrewCoffee;
import com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks.GetWater;
import com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks.SelectCoffee;

public class MainApp {
    public static void main(String[] args) {

        // Run the whole workflow
        Context ec = new Context();
        ec.set("COFFEE_TYPE","Mocha Blend");
        WorkflowEngine engine = new WorkflowEngine(new GetWater(),new SelectCoffee(), new BrewCoffee());
        engine.run(ec);

        // start from 2/3 of tasks
        engine.run(ec,2);
    }
}
