package com.demo.service;

public class UserServiceImpl implements IUserService{
	public void doSomeThing(){
		System.out.println("call doSomeThing method...");
	}

	public void doOtherThing() {
		System.out.println("call doOtherThing method...");
	} 
	
	public void setUp() {
		System.out.println("初始化完毕，执行后续工作...");
	}
	public void tearDown() {
		System.out.println("对象销毁，进行资源释放...");
	}

}
