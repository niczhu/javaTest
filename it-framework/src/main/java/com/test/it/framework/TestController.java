package com.test.it.framework;

import com.test.it.framework.exception.DefaultErrorCodeEnum;
import com.test.it.framework.exception.ErrorHelper;
import com.test.it.framework.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/test")
    @ResponseBody
    public Object test(@Valid @RequestBody TestBean testBean) {
        System.out.println("/test");
        AssertUtil.notNull(testBean, DefaultErrorCodeEnum.NAME_EXISTS);
        return "test.";
    }

    @GetMapping(value = "/ex")
    @ResponseBody
    public Object testEx() {
        TestBean testBean1 = new TestBean();
        testBean1.setAge(10);
        testBean1.setName("测试姓名");
        return testBean1;
    }

    @GetMapping(value = "/utf")
    @ResponseBody
    public Object testUtf() {
        return "测试";
    }

}
