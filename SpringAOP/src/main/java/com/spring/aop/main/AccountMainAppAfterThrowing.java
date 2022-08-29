package com.spring.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AccountConfig;
import com.spring.aop.dao.AccountDAO;

public class AccountMainAppAfterThrowing {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean(AccountDAO.class);
		
		try {
			accountDAO.exceptionTest(true);
		} catch (Exception e) {
			System.out.println("Main Exc: " + e);
		}
		
		System.out.println("***Main Program");
		
		applicationContext.close();
		
	}
}

