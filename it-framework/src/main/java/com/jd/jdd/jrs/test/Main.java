package com.jd.jdd.jrs.test;


import com.jd.jdd.jrs.it.test.if_else.BaseProcessor;
import com.jd.jdd.jrs.it.framework.model.TableFieldEnum;

public class Main {

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        testBean.setName("nick");
        testBean.setAge(10);
        System.out.println(testBean);
        System.out.println(testBean.toString());

        System.out.println(TestBeanEnum.ADMIN.getClass());
        System.out.println(TestBeanEnum.ADMIN.getClass().isAssignableFrom(TableFieldEnum.class));
        System.out.println(TestBeanEnum.ADMIN instanceof TableFieldEnum);
        System.out.println(TestBeanEnum.ADMIN.getClass().isAssignableFrom(TableFieldEnum.class));

        testIfElse();
    }

    public static void testIfElse() {
        final String A = "a";
        final String B = "b";
        BaseProcessor baseProcessor = new BaseProcessor(A);
        baseProcessor.invoke();
    }
}
