package com.test.multiDataSource.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MultiDataSourceAop {

    @Pointcut("execution(* com.test.multiDataSource.dao..*.*(..))")
    public void pointcut(){
    }

    @Before("pointcut()" )
    public void before(JoinPoint joinPoint){

        Object target = joinPoint.getTarget();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        DataSourceType annotation = method.getAnnotation(DataSourceType.class);
        if(annotation==null){
            MultiDataSourceHandler.setDataSource(MultiDataSourceHandler.MASTER);
            return;
        }

        MultiDataSourceHandler.setDataSource(annotation.value());

    }

}
