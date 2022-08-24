package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

	@Before("execution(public void addAcc*())")
	public void beforeAddAccountingAdvice() {
		System.out.println("------ Before addAccountingAdvice");
	}
}
