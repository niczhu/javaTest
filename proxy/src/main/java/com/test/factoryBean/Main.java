package com.test.factoryBean;

import org.aspectj.weaver.ast.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static  void  main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        /**
         * 这里如果用getBean(class)方法会报异常!
         * 因为spring把对象转换成BD的过程中保存的是beanName作为key,
         * 而MyFactoryBean的getObject返回的是Tmp而不是MyFactoryBean.class
         *
         */
//        Temp myFactoryBean = (Temp) ac.getBean(MyFactoryBean.class);

        Temp myFactoryBean = (Temp) ac.getBean("myFactoryBean");
        myFactoryBean.test();
    }


}
