package com.test.factoryBean;

import org.aspectj.weaver.ast.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static  void  main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        /**
         * 这里如果用getBean(class)方法会报异常!
         */
//        Temp myFactoryBean = (Temp) ac.getBean(MyFactoryBean.class);

        Temp myFactoryBean = (Temp) ac.getBean("myFactoryBean");
        myFactoryBean.test();
    }


}
