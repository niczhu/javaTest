package com.test.mydubbo.spi;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;
@Adaptive
public class BenzCarImpl implements Car {

    @Override
    public void run() {
        System.out.println("====benz car run =====");
    }
}
