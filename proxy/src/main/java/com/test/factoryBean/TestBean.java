package com.test.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements FactoryBean {

    public TestBean(){
        System.out.println("testBean struct.");
    }

    @Override
    public Object getObject() throws Exception {
        System.out.println("factoryBean -> getObject() ");
        return TargetBean.class;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void say(){
        System.out.println("TargetBean --> say() ");
    }
}
