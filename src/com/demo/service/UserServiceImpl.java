package com.demo.service;

public class UserServiceImpl implements IUserService{
	public void doSomeThing(){
		System.out.println("call doSomeThing method...");
	}

	public void doOtherThing() {
		System.out.println("call doOtherThing method...");
	} 
	
	public void setUp() {
		System.out.println("��ʼ����ϣ�ִ�к�������...");
	}
	public void tearDown() {
		System.out.println("�������٣�������Դ�ͷ�...");
	}

}
