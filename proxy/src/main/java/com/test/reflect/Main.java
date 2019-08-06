package com.test.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main
{

    public static void main(String[] args) throws Exception {

        Class<?> c = Class.forName("com.test.reflect.TestBean");

        TestBean test = ((TestBean) c.newInstance());
        TestBean testBean = new TestBean();

        Constructor<?>[] declaredConstructors = testBean.getClass().getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }


        Constructor<?>[] declaredConstructors1 = c.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors1) {
            System.out.println(constructor);
        }

        System.out.println("-----------------");
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------fields ---------");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }
}
