package com.md.it.test.if_else;

/**
 * BProcessor
 *
 * @author zhuhaipeng6 in 2020/4/11 15:29
 * @version 1.0
 **/
public class BProcessor implements Processor {
    public BProcessor() {
    }

    @Override
    public void execute() {
        System.out.println(" b execute ");
    }
}
