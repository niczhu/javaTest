package com.test.it.framework.constraint.validator;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractValidator<DT, T> implements Validator {
    public AbstractValidator() {
    }

    public void validate(Object obj, Field field) {
        Annotation annotation = field.getAnnotation(this.support());

        try {
            this.doValidate(annotation, FieldUtils.readField(field, obj, true));
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    abstract void doValidate(Object annotation, Object field);
}
