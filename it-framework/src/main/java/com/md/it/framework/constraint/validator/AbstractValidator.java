package com.md.it.framework.constraint.validator;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * AbstractValidator
 *
 * @author zhuhaipeng6 in 2020/2/25
 * @version 1.0
 **/
public abstract class AbstractValidator<T, VT> implements Validator {
    Logger logger = LoggerFactory.getLogger(AbstractValidator.class);

    public AbstractValidator() {
    }

    public void validate(Object obj, Field field) {
        Class annoClass = this.support();
        Annotation annotation = field.getAnnotation(annoClass);

        try {
            VT value = (VT) FieldUtils.readField(field, obj, true);
            this.doValidate(value, (T) annotation, field.getName());
        } catch (IllegalAccessException | IllegalArgumentException e) {
            logger.error("Validator exception {}", e.getMessage(), e);
        }
    }

    abstract void doValidate(VT fieldValue, T annotation, String fieldName);
}
