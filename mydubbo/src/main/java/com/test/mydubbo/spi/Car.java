package com.test.mydubbo.spi;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Car {

    @Adaptive
    public void run();
}
