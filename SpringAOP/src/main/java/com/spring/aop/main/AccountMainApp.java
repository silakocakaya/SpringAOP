package com.spring.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AccountConfig;
import com.spring.aop.dao.AccountDAO;

public class AccountMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean(AccountDAO.class);
		
		accountDAO.addAccount();
		
		accountDAO.addAccounts();
		
		accountDAO.addSomething();
		
		accountDAO.setFirstName("Sila");
		
		accountDAO.getFirstName();
		
		applicationContext.close();
		
	}
}

