package com.test.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 使用component 及  注解方式配置aspect
 * created by zhp on 2019年4月20日
 */

@Component
@Aspect
public class AspectConfig {
	
	/**
	 * 拦截com.test.aop包中所有的方法
	 */
	@Pointcut("execution(* com.test.springaop..*.*(..))")// the pointcut expression
	private void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void beforeAdvice(ProceedingJoinPoint  proceedingJoinPoint){
		Signature signature = proceedingJoinPoint.getSignature();
		System.out.println(signature);

		System.out.println("aspectConfig class -> befor ...");
	}
	
	@After("pointcut()")
	public void afterAdvice(){
		System.out.println("aspectConfig class -> after ...");
	}
	

}
