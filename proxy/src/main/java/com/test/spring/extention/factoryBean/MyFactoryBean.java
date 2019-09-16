package com.test.spring.extention.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author zhuhp
 * @Date 2019/5/21
 */
@Component("myFactoryBean")
public class MyFactoryBean  implements FactoryBean {
    public void testBean(){
        System.out.println("MyFactoryBean testBean() method");
    }

    @Override
    public Object getObject() throws Exception {
        return new Temp();
    }

    @Override
    public Class<?> getObjectType() {
        return Temp.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
