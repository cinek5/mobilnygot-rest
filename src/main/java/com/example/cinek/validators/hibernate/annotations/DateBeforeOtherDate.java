package com.example.cinek.validators.hibernate;


import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Cinek on 06.01.2019.
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = {  })
public @interface DateBeforeOtherDate {

    String message() default "{com.example.validation.ValidAddress.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String date();
    String otherDate();
}