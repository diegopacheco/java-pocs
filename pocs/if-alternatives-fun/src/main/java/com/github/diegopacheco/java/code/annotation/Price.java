package com.github.diegopacheco.java.code.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
@Documented
public @interface Price {
    String alias();
    Class clazz();
    String value();
}