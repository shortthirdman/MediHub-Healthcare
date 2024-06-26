package com.shortthirdman.medihub.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Loggable {
    boolean showValues() default true;

    String[] showParameters() default {};

    String[] hideParameters() default {};
}