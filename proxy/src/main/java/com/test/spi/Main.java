package com.test.spi;


import sun.reflect.Reflection;

import javax.xml.soap.Node;
import java.sql.Array;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ServiceLoader<Filter> load = ServiceLoader.load(Filter.class);

        for (Filter filter : load) {
            filter.invoke();
        }

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver driver;

        System.out.println(drivers.hasMoreElements());

        while (drivers.hasMoreElements())
        {
            driver = drivers.nextElement();
            System.out.println(driver.getClass() + "------" + driver.getClass().getClassLoader());
        }

        System.out.println(DriverManager.class.getClassLoader());



        PriorityQueue<Test> priorityQueue = new PriorityQueue<Test>();
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();
        Test t4 = new Test();
        t1.age = 2;
        t2.age = 8;
        t3.age = 1;
        t4.age = 7;

        priorityQueue.add(t1);
        priorityQueue.add(t2);
        priorityQueue.add(t3);
        priorityQueue.add(t4);


        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll().age);
        }

    }
}
