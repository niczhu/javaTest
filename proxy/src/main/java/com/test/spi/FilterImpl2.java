package com.test.spi;

public class FilterImpl2 implements Filter {
    @Override
    public String invoke() {
        System.out.println("--------filterimpl----------");
        return "filter 2 >>";
    }
}
