package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        stopWatchTest();


        //SpringApplication.getSpringFactoriesInstances()
        // EventPublishingRunListener
        // SimpleApplicationEventMulticaster # multicastEvent()
        // SimpleApplicationEventMulticaster # doInvokeListener()
        // DelegatingApplicationListener # onApplicationEvent()
        // LiquibaseServiceLocatorApplicationListener # onApplicationEvent()

        int m =2;
        if(m==2 ||(m++)==4){
            System.out.println(m);
        }

    }

    public static void stopWatchTest(){
        StopWatch sw = new StopWatch();
        sw.start("起床");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sw.stop();

        System.out.println(sw.prettyPrint());

        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
    }
}
