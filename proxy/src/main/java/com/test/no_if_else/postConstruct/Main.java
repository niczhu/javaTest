package com.test.no_if_else.postConstruct;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        RegistProcessService registProcess = (RegistProcessService) ctx.getBean("registProcessService");
        registProcess.allProcesser();

        registProcess.allList();

        new HashSet<>();
        new HashMap<String ,String>();
        new ArrayList<Object>();

       new ArrayList<>();

        new Thread();


        String a = "ab";
        String b = "ab";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }




}
