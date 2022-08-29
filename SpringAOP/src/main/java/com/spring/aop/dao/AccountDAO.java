package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.main.Account;

@Component
public class AccountDAO {
	
	private String firstName;
	
	public void exceptionTest(boolean flag) {
		
		if(flag) {
			throw new RuntimeException();
		}
	}
	
	public List<Account> findAccounts() {
		
		List<Account> accountList = new ArrayList<Account>();
		
		Account account = new Account("Sila", "1");
		Account account2 = new Account("Koray", "2");
		Account account3 = new Account("Duygu", "3");
		
		accountList.add(account);
		accountList.add(account2);
		accountList.add(account3);
		
		System.out.println("**********************findAccounts()");
		
		return accountList;
	}
	
	public void addJoinPointAccount(Account account) {
		System.out.println("Real Account Added: " + account);
	}

	public void addAccount() {
		System.out.println("Account added: " + this.getClass());
	}
	
	public void addAccounts() {
		System.out.println("Accounts added: " + this.getClass());
	}
	
	public void addSomething() {
		System.out.println("Somethings added: " + this.getClass());
	}

	public String getFirstName() {
		System.out.println("getFirstName: " + firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("setFirstName: " + firstName);
	}
	
	public void orderTest() {
		System.out.println("Order Test");
	}
	
	public void joinPointTest() {
		System.out.println("Join Point Test");
	}
	
	public static void joinPointStatic() {
		System.out.println("StaticTest");
	}
}
