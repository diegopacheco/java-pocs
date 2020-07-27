package com.github.diegopacheco.javapocs.model.test;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(max = 10)
    @Min(1)
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
