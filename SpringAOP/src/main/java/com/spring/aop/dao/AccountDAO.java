package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.main.Account;

@Component
public class AccountDAO {
	
	private String firstName;
	
	public void addJoinPointAccount(Account account) {
		System.out.println("Real Account Added: " + this.getClass());
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
