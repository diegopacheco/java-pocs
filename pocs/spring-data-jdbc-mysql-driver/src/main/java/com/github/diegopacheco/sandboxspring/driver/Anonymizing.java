package com.github.diegopacheco.sandboxspring.driver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Anonymizing {
    String dbFieldName();
    AnonymizingStrategy strategy() default AnonymizingStrategy.STAR;
}