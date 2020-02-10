package com.test.it.framework;

import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public Object test(@Valid @RequestBody TestBean testBean) {

//        ErrorHelper.genExByCode(DefaultErrorCodeEnum.NAME_EXISTS);

        return "test..";
    }

    @GetMapping(value = "/ex")
    public Object testEx(TestBean testBean){
//        AssertUtil.equals("a","g",DefaultErrorCodeEnum.UNKNOWN);
        ErrorHelper.genExByCode(DefaultErrorCodeEnum.AUTH_CODE_ERROR);
        return testBean;
    }
}
