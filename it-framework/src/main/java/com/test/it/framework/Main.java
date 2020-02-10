package com.test.it.framework;


public class Main {

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        testBean.setName("nick");
        testBean.setAge(10);
        System.out.println(testBean);
        System.out.println(testBean.toString());
    }
}
