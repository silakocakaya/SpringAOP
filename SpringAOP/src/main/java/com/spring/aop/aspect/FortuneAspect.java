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

	@Around("execution(public * getFortune())")
	public Object aroundFortuneService(ProceedingJoinPoint proceedingJoinPoint) {
		
		long begin = System.currentTimeMillis();
		
		Object object = null;
		try {
			object = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		long duration = (end-begin);
		
		System.out.println("Service Time: " + duration / 1000.0 + " ms");
		
		return object;
	}
	
	@Around("execution(public * getFortune(*))")
	public Object aroundFortuneServiceWithError(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long begin = System.currentTimeMillis();
		
		Object object = null;
		try {
			object = proceedingJoinPoint.proceed();
		}  catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return e.getMessage();
		} 
		
		long end = System.currentTimeMillis();
		
		long duration = (end-begin);
		
		System.out.println("Service Time: " + duration / 1000.0 + " ms");
		
		return object;
	}
	
}
