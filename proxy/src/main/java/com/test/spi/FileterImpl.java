package com.test.spi;

public class FileterImpl implements Filter{


    @Override
    public String invoke() {
        System.out.println("=======fileterImpl1111 invoke  111=========");
        return "hello spi";
    }
}
