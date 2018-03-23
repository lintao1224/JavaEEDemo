package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.aop.IUserService;

public class Test2 {
	@Test
	public void test01() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop1.xml");
		IUserService userService = (IUserService) context.getBean("myUserService");
		userService.doSomeThing();
		userService.doOtherThing();
		userService.doThirdThing();
		try {
			userService.doFouthThing();
		} catch (Exception e) {
			// System.out.println(e);
		}
		userService.doFifthThing();
	}

}
