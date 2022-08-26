package com.spring.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AccountConfig;
import com.spring.aop.dao.AccountDAO;

public class AccountMainAppJoinPoint {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean(AccountDAO.class);
		
		Account account = new Account();
		account.setName("Sila");
		accountDAO.addJoinPointAccount(account);
		
		applicationContext.close();
		
	}
}

