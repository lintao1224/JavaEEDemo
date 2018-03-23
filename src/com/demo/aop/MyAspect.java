package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before(){
		System.out.println("ǰ��֪ͨ");
		ValidateUtils.doValidate();
	}
	public void after(){
		System.out.println("����֪ͨ");
		LogUtils.doLog();
	}
	public void afterReturning(Object result){
		System.out.println("���÷���ֵ��ǿ��"+result);
	}
	public void afterThrowing(Throwable e){
		System.out.println("�쳣֪ͨ��"+e.getMessage());
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("����֪ͨǰ��");
		Object result=pjp.proceed();
		System.out.println("����֪ͨ��");
		return result;
	}

}
