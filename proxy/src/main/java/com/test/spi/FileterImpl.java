package com.test.spi;

public class FileterImpl implements Filter{


    @Override
    public String invoke() {
        System.out.println("=======fileterImpl invoke =========");
        return "hello spi";
    }
}
