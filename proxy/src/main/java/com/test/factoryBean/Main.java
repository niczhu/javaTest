package com.test.factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static  void  main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
//        TargetBean bean = ac.getBean(TargetBean.class);
        TestBean bean = ac.getBean(TestBean.class);
        bean.say();
    }


}
