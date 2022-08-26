package com.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.spring.aop.main.Account;

@Aspect
@Component
public class AccountAspectAfterReturning {

		//returning = "result" ve List<Account> result da isimler ayni olmali
		@AfterReturning(pointcut = "execution(public * findAccounts())",
				returning = "result")
		public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
			
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			
			System.out.println("--- Method Sig: " + methodSignature);
			
			String method = methodSignature.toShortString();
			System.out.println("--- Method: " + method);
			
			System.out.println("--- Result: " + result);
			
			makeNameUpperCase(result);
			
			System.out.println("--- Result: " + result);
		}
		
		public void makeNameUpperCase(List<Account> result) {
			
			if(CollectionUtils.isEmpty(result))
				return;
			
			for (Account account : result) {
				account.setName(account.getName().toUpperCase());
			}
		}
	
}
