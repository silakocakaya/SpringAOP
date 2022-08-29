package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspectAfterThrowing {

	@AfterThrowing(pointcut = "execution(public * exceptionTest(..))",
			throwing = "exc")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		String method = methodSignature.toShortString();
		System.out.println("--- Method: " + method);
		
		System.out.println("--- Exc: " + exc);
	}

}
