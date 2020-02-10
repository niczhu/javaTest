package com.test.it.framework.exception;

import com.test.it.framework.thread.PrjThread;
import lombok.extern.slf4j.Slf4j;

/**
 * 未捕获异常处理类
 */
@Slf4j
public class PrjExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t.getClass() == PrjThread.class) {
            log.warn("异步线程{}出现异常[{}],extra={}", t, ((PrjThread) t).getTraceId(), ((PrjThread) t).getExtra());
        } else {
            log.warn("异步线程{}出现异常", t);
        }
    }
}
