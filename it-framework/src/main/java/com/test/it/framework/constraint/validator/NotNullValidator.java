package com.test.it.framework.constraint.validator;

import com.test.it.framework.constraint.annotation.NotNull;

public class NotNullValidator extends AbstractValidator<NotNull,String> {
    @Override
    void doValidate(Object var1, Object var2) {

    }

    @Override
    public Class support() {
        return null;
    }
}
