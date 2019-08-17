package com.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Filter
{
    public String invoke();
}
