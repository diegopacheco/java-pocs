package com.github.diegopacheco.java.pocs.workflow.decorator;

import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.BrewCoffee;
import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.GetWater;
import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.SelectCoffee;

public class MainApp {
    public static void main(String[] args) {
        Context ec = new Context();
        ec.set("COFFEE_TYPE","Mocha Blend");
        ec.set("STEP","1");

        // full workflow running.
        new GetWater(new SelectCoffee(new BrewCoffee())).execute(ec);

        // start from 2/3 of tasks
        ec = new Context();
        ec.set("COFFEE_TYPE","Mocha Blend");
        ec.set("STEP","1");
        ResumeFactory factory = new ResumeFactory();
        Task task  = factory.build(2);
        task.execute(ec);

    }
}
