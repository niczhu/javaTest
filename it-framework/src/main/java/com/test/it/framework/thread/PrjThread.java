package com.test.it.framework.thread;

public class PrjThread  extends Thread {

    private String traceId;
    private Object extra;

    public PrjThread(Runnable runnable, String traceId) {
        super(runnable);
        this.traceId = traceId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
