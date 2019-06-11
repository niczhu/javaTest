package com.test.mydubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class SpiMain {
    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car car = extensionLoader.getExtension("audi");

        car.run();

    }
}
