package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

	@Before("execution(public void addAcc*())")
	public void beforeAddAccountingAdvice() {
		System.out.println("------ Before addAccountingAdvice");
	}
	
	@Before("execution(public void com.spring.aop.dao.*.*())")
	public void beforeMethodsInPackage() {
		System.out.println("---*** Before beforeMethodsInPackage");
	}
	
	//Pointcut'i tekrar tekrar kullanabiliriz bu sayede
	@Pointcut("execution(public void addAccount*()) || execution(public void addSomething())")
	public void createPointCut() {}
	
	@Before("createPointCut()")
	public void beforeMethodWithPointCut1() {
		System.out.println("------ beforeMethodWithPointCut1");
	}
	
	@Before("createPointCut()")
	public void beforeMethodWithPointCut2() {
		System.out.println("------ beforeMethodWithPointCut2");
	}
	
	@Before("all()")
	public void beforeAll() {
		System.out.println("-***++ Before beforeAll");
	}
	
	@Pointcut("execution(public * set*(..))")
	public void setter() {}
	
	@Pointcut("execution(public * get*(..))")
	public void getter() {}
	
	@Pointcut("execution(public * com.spring.aop.dao.*.*(..))")
	public void all() {}
	
	@Before("all() && !setter() && !getter()")
	public void beforeAllNotSetGet() {
		System.out.println("-***++ Before beforeAllNotSetGet");
	}
	
}
