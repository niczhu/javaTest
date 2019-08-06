package com.test.no_if_else.postConstruct;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        RegistProcessService registProcess = (RegistProcessService) ctx.getBean("registProcessService");
        registProcess.allProcesser();

//        registProcess.allList();

    }



}
