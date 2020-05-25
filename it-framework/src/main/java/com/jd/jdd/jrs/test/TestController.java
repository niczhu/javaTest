package com.jd.jdd.jrs.test;

import com.jd.jdd.jrs.it.framework.constraint.service.ValidatorService;
import com.jd.jdd.jrs.it.framework.exception.DefaultErrorCodeEnum;
import com.jd.jdd.jrs.it.framework.exception.UncaughtExceptionHandler;
import com.jd.jdd.jrs.it.framework.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    ValidatorService validatorService;
    @Autowired
    UncaughtExceptionHandler uncaughtExceptionHandler;

    @GetMapping(value = "/hello")
    public Object hello() {
        return "hello world";
    }

    @GetMapping(value = "/t")
    @ResponseBody
    public Object te() {
        TestBean testBean = new TestBean();
        testBean.setName("niczhu");
        testBean.setId("12");
        testBean.setAge(9);
        testBean.setTestBean(TestBeanEnum.ADMIN);

        validatorService.validate(testBean);

//        ErrorHelper.genExByCode(DefaultErrorCodeEnum.NAME_EXISTS);
        return testBean;
    }

    @PostMapping(value = "/test")
    @ResponseBody
    public Object test(@Valid @RequestBody TestBean testBean) {
        System.out.println("/test");
        AssertUtil.notNull(testBean, DefaultErrorCodeEnum.NAME_EXISTS);
        AssertUtil.notNull(testBean.getId(), DefaultErrorCodeEnum.MISS_PARAMETER);
        return testBean;
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

    @GetMapping(value = "/uncaught")
    @ResponseBody
    public Object uncaught() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(".aaaaaaaaaaaaaaaaaaa");
                int i = 100/0;
            }
        });
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread.start();
        throw new NullPointerException("test null exp");
    }
}
