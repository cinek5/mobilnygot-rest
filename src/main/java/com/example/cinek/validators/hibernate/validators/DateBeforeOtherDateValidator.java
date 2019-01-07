package com.example.cinek.validators.hibernate.validators;

import com.example.cinek.validators.hibernate.annotations.DateBeforeOtherDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Cinek on 06.01.2019.
 */
public class DateBeforeOtherDateValidator implements ConstraintValidator<DateBeforeOtherDate, Object> {

    private String date;
    private String otherDate;

    @Override
    public void initialize(DateBeforeOtherDate constraintAnnotation) {
        date = constraintAnnotation.date();
        otherDate = constraintAnnotation.otherDate();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Object dateFieldValue = getFieldValue(o,date);
            Object otherDateFieldValue = getFieldValue(o,otherDate);

            Date date = (Date)dateFieldValue;
            Date otherDate = (Date) otherDateFieldValue;
            return date.before(otherDate);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Object getFieldValue(Object object, String fieldName) throws Exception {
        Class<?> clazz = object.getClass();
        Field passwordField = clazz.getDeclaredField(fieldName);
        passwordField.setAccessible(true);
        return passwordField.get(object);
    }
}
