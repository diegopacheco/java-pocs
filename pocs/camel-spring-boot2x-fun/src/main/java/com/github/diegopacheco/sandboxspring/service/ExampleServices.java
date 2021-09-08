package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.MyBean;

public class ExampleServices {
    public static void example(MyBean bodyIn) {
        bodyIn.setName( "Hello, " + bodyIn.getName() );
        bodyIn.setId(bodyIn.getId()*10);
    }
}