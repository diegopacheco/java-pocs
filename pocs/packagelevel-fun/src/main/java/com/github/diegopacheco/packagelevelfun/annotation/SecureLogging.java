package com.github.diegopacheco.packagelevelfun.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Mark that logging should be secure.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureLogging { }
