package com.test.spi;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<Filter> load = ServiceLoader.load(Filter.class);
        for (Filter filter : load) {

            System.out.println("file foreach"+ filter.getClass().getSimpleName());

            filter.invoke();

        }

    }
}
