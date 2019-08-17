package com.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class Main
{

    public static void main(String[] args) {
        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);

        Filter test = (Filter) extensionLoader.getExtension("test");
        test.invoke();
    }
}
