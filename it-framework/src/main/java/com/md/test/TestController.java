package com.md.test;

import com.md.it.framework.constraint.service.ValidatorService;
import com.md.it.framework.exception.DefaultErrorCodeEnum;
import com.md.it.framework.exception.UncaughtExceptionHandler;
import com.md.it.framework.utils.AssertUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "标签接口", value = "标签管理")
@RestController
@RequestMapping("/")
public class TestController {
    Logger logger = LoggerFactory.getLogger("com.md.test.web");
    @Autowired
    TestService testService;
    @Autowired
    ValidatorService validatorService;

    @ApiOperation(value = "根据id查询", notes = "整型且必需")
    @GetMapping(value = "/hello")
    public Object hello() {
        return "hello world";
    }

    @GetMapping(value = "/t")
    @ResponseBody
    public Object te() {
        TestBean testBean = new TestBean();
//        testBean.setName("niczhu");
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
        AssertUtil.notNull(null,DefaultErrorCodeEnum.MISS_PARAMETER);
        return testBean1;
    }

}
