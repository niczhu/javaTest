package com.test.springEvent.javaEvent;

import java.util.EventObject;

public class MyEvent extends EventObject {

    public MyEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
