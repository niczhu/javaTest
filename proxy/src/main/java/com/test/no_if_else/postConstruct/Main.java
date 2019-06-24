package com.test.no_if_else.postConstruct;

import com.test.no_if_else.postConstruct.processer.AliProcess;
import com.test.no_if_else.postConstruct.processer.WxProcess;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        RegistProcessService registProcess = (RegistProcessService) ctx.getBean("registProcessService");
        registProcess.allProcesser();

    }




}
