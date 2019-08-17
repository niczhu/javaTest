package com.dubbo.spi;

public class FilterImpl implements Filter {

    @Override
    public String invoke() {
        System.out.println("===dubbo spi ==");
        return "hello dubbo spi";
    }
}
