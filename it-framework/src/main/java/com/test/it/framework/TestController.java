package com.test.it.framework;

import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/test")
    public Object test(@Valid @RequestBody TestBean testBean) {

//        ErrorHelper.genExByCode(DefaultErrorCodeEnum.NAME_EXISTS);

        return "test.";
    }

    //produces = "application/json;charset=UTF-8"
    @GetMapping(value = "/ex")
    public Object testEx() {
//        AssertUtil.equals("a","g",DefaultErrorCodeEnum.UNKNOWN);
        TestBean testBean1 = new TestBean();
        testBean1.setAge(10);
        testBean1.setName("测试姓名");
//        ErrorHelper.genExByCode(DefaultErrorCodeEnum.AUTH_CODE_ERROR);
        return testBean1;
    }

    @GetMapping(value = "/utf")
    public String testUtf() {
        return "测试";
    }
}
