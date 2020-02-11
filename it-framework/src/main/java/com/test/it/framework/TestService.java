package com.test.it.framework;

import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TestService {

    public Object testValidate(@Valid TestBean testBean){
        System.out.println(testBean);
        return testBean;
    }

}
