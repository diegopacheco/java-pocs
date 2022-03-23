package com.github.diegopacheco.java.pocs.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Owner {
    String email() default "dev@dev.com";
}
