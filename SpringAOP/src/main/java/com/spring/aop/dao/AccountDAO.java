package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println("Account added: " + this.getClass());
	}
	
	public void addAccounts() {
		System.out.println("Accounts added: " + this.getClass());
	}
}
