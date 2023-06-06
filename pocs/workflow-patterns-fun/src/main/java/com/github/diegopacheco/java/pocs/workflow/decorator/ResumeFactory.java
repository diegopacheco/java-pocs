package com.github.diegopacheco.java.pocs.workflow.decorator;

import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.BrewCoffee;
import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.GetWater;
import com.github.diegopacheco.java.pocs.workflow.decorator.tasks.SelectCoffee;

public class ResumeFactory {

    public Task build(int stopAt){
        Task task = null;
        switch (stopAt){
            case 3:
                task = new BrewCoffee();
            break;
            case 2:
                task = new SelectCoffee(new BrewCoffee());
                break;
            case 0:
            case 1:
            default:
                task = new GetWater(new SelectCoffee(new BrewCoffee()));
        }
        return task;
    }

}
