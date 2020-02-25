package com.test.it.framework.constraint.validator;

import com.test.it.framework.constraint.annotation.NotNull;
import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import org.apache.commons.lang3.StringUtils;

public class NotNullValidator extends AbstractValidator<NotNull, Object> {

    @Override
    void doValidate(Object fieldValue, NotNull annotation, String fieldName) {
        if (null == fieldValue) {
            String prop = annotation.propName();
            if (StringUtils.isBlank(prop)) {
                prop = fieldName;
            }
            ErrorHelper.genExByCode(DefaultErrorCodeEnum.INVALID_PARAM, String.format("[%s]不能为空", prop));
        }
    }

    @Override
    public Class<NotNull> support() {
        return NotNull.class;
    }
}
