package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AccountAspectOrder1 {

	@Before("execution(public void orderTest*())")
	public void orderTest() {
		System.out.println("------11 Before orderTest");
	}
	
}
