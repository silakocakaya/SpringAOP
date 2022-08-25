package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AccountAspectOrder2 {

	@Before("execution(public void orderTest*())")
	public void orderTest() {
		System.out.println("------22 Before orderTest");
	}
	
}
