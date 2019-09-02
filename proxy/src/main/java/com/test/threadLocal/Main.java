package com.test.threadLocal;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Main
{

    public static void main(String[] args) {
        LocalSession session = new LocalSession();
        session.setId(1);

        Test.getSession();

    }
}
