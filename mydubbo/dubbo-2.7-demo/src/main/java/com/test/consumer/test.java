package com.test.consumer;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Filter;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
            ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
            Filter url = extensionLoader.getExtension("method");
    }
}
