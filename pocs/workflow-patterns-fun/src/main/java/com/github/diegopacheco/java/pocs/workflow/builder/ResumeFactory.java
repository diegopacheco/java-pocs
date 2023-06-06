package com.github.diegopacheco.java.pocs.workflow.builder;

import com.github.diegopacheco.java.pocs.workflow.builder.tasks.BrewCoffee;
import com.github.diegopacheco.java.pocs.workflow.builder.tasks.GetWater;
import com.github.diegopacheco.java.pocs.workflow.builder.tasks.SelectCoffee;

public class ResumeFactory {

    public WorkflowEngine build(int stopAt){
        WorkflowEngine.Builder builder = new WorkflowEngine.Builder();
        WorkflowEngine engine = null;
        switch (stopAt){
            case 3:
                builder.addTask(new BrewCoffee());
            break;
            case 2:
                builder.addTask(new SelectCoffee());
                builder.addTask(new BrewCoffee());
                break;
            case 0:
            case 1:
            default:
                builder.withInitialTask(new GetWater());
                builder.addTask(new SelectCoffee());
                builder.addTask(new BrewCoffee());
        }
        engine = builder.build();
        return engine;
    }

}
