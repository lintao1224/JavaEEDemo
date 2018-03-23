package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before(){
		System.out.println("前置通知");
		ValidateUtils.doValidate();
	}
	public void after(){
		System.out.println("后置通知");
		LogUtils.doLog();
	}
	public void afterReturning(Object result){
		System.out.println("后置返回值增强："+result);
	}
	public void afterThrowing(Throwable e){
		System.out.println("异常通知："+e.getMessage());
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知前：");
		Object result=pjp.proceed();
		System.out.println("环绕通知后：");
		return result;
	}

}
