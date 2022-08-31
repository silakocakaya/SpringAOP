package com.spring.aop.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneDAO {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
			
			System.out.println("FortuneDAO: Late Day");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "FortuneDAO Return";
	}
	
	public String getFortune(boolean value) {

		if(value) {
			throw new RuntimeException("getFortune Error");
		}
		return getFortune();
	}
}
