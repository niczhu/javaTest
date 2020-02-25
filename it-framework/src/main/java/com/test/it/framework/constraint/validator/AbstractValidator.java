package com.test.it.framework.constraint.validator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Slf4j
public abstract class AbstractValidator<T, V> implements Validator {
    public AbstractValidator() {
    }

    public void validate(Object obj, Field field) {
        Class at = this.support();
        Annotation annotation = field.getAnnotation(at);

        try {
            V value = (V) FieldUtils.readField(field, obj, true);
            this.doValidate(value, (T) annotation, field.getName());
        } catch (IllegalAccessException | IllegalArgumentException e) {
            log.error("Validator exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    abstract void doValidate(V FieldValue, T annotation, String FieldName);
}
