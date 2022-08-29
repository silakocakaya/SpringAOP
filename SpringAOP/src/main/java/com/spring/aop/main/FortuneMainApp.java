package com.spring.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AccountConfig;
import com.spring.aop.dao.FortuneDAO;

public class FortuneMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfig.class);
		
		try {
			FortuneDAO fortuneDAO = applicationContext.getBean(FortuneDAO.class);
			
			System.out.println("FortuneMainApp: Before Service Call");
			String result = fortuneDAO.getFortune();
			System.out.println("FortuneMainApp: After Service Call: ->> " + result);
		} finally {
			applicationContext.close();
		}
	}
}
