package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-10)
public class FortuneAspect {

	@Around("execution(public void getFortune())")
	public void aroundFortuneService(ProceedingJoinPoint proceedingJoinPoint) {
		
		long begin = System.currentTimeMillis();
		
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		long duration = (end-begin);
		
		System.out.println("Service Time: " + duration / 1000.0 + " ms");
	}
	
}
