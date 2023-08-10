package com.github.diegopacheco.java.code.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Price {
    String alias();
    Class clazz();
    String value();
}