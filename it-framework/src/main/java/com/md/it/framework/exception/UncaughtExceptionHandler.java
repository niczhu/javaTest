package com.md.it.framework.exception;

import com.md.it.framework.thread.PrjThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 未捕获异常处理类
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    Logger logger = LoggerFactory.getLogger(UncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (t.getClass() == PrjThread.class) {
            logger.warn("异步线程{}出现异常[{}],extra={}", t, ((PrjThread) t).getTraceId(), ((PrjThread) t).getExtra());
        } else {
            logger.warn("异步线程{}出现异常", t);
        }
    }
}
