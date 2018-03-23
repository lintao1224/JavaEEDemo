package com.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Student;
import com.demo.bean2.Teacher;
import com.demo.factory.ServiceFactory;
import com.demo.service.IUserService;

public class Test01 {

	@Test
	public void test01() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService) context.getBean("userService");
		userService.doSomeThing();
		userService.doOtherThing();
	}

	@Test
	public void test02() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		ServiceFactory factory = (ServiceFactory) context.getBean("factory");
		IUserService service = factory.getUserService();
		service.doSomeThing();
	}

	@Test
	public void test03() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		IUserService service = (IUserService) context.getBean("userService");
		service.doSomeThing();
	}

	@Test
	public void test04() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
		IUserService service = (IUserService) context.getBean("userService");
		service.doSomeThing();
	}

	@Test
	public void test05() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
		IUserService service = (IUserService) context.getBean("userService");
		service.doSomeThing();
	}

	@Test
	public void test06() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext6.xml");
		IUserService service = (IUserService) context.getBean("userService");
		service.doSomeThing();
		service.doOtherThing();
		((ClassPathXmlApplicationContext) context).close();

	}

	@Test
	public void test07() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di1.xml");
		Student student = (Student) context.getBean("student1");
		System.out.println(student);
		Student student2 = (Student) context.getBean("student2");
		System.out.println(student2);
	}

	@Test
	public void test08() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di2.xml");
		Student student = (Student) context.getBean("myStudent");
		System.out.println(student);
	}

	@Test
	public void test09() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di3.xml");
		Student student = (Student) context.getBean("myStudent");
		System.out.println(student);
		Student student2 = (Student) context.getBean("myStudent2");
		System.out.println(student2);
	}

	@Test
	public void test10() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di4.xml");
		com.demo.bean2.Student student = (com.demo.bean2.Student) context.getBean("myStudent");
		System.out.println(student);
	}

	@Test
	public void test11() {
		ApplicationContext context = new ClassPathXmlApplicationContext("di4.xml");
		Teacher teacher = (Teacher) context.getBean("myTeacher");
		System.out.println(teacher);
	}

}
