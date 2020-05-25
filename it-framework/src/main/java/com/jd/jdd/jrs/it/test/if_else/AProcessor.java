package com.jd.jdd.jrs.it.test.if_else;

/**
 * AProcessor
 *
 * @author zhuhaipeng6 in 2020/4/11 15:27
 * @version 1.0
 **/
public class AProcessor implements Processor {

    public AProcessor() {
    }

//    @Override
//    public void doExecute() {
//        System.out.println(" a doExecute ");
//    }

    @Override
    public void execute() {
        System.out.println(" a execute ");
    }
}
