package com.spring.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AccountConfig;
import com.spring.aop.dao.AccountDAO;

public class AccountMainAppAfterReturning {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean(AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("***Main Program");
		System.out.println(accounts);
		
		
		applicationContext.close();
		
	}
}

