package com.github.diegopacheco.sandbox.java.gdrl.guice.logger;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
@Scope
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Log {}