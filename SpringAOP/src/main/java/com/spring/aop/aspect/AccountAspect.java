package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.dao.AccountDAO;
import com.spring.aop.main.Account;

@Aspect
@Component
@Order(-5)
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
	
	@Before("execution(public * join*())")
	public void paramsWithJoinPoint(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("methodSig: " + methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			
			System.out.println(arg);
			
			if(arg instanceof AccountDAO) {
				
				AccountDAO accountDAO = (AccountDAO) arg;
				System.out.println(accountDAO.getFirstName());
			}
		}
	}
	
	@Before("execution(public * addJoinPointAccount*(..))")
	public void paramsWithAddJoinPoint(JoinPoint theJoinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("methodSig: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());		
				
				theAccount.setLevel("8");

			}
		}
	}
	
}
