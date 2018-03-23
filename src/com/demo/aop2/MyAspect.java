package com.demo.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class MyAspect {
	@Before("execution(* *..UserServiceImpl.doSomeThing())")
	public void before(){
		System.out.println("注解配置AOP前置通知");
	}
	@After("execution(* *..UserServiceImpl.doOtherThing())")
	public void after(){
		System.out.println("注解配置AOP后置通知");
	}
	@AfterReturning(value="execution(* *..UserServiceImpl.doThirdThing())",returning="result")
	public void afterReturning(Object result){
		System.out.println("后置返回值增强："+result);
	}
	@AfterThrowing(value="execution(* *..UserServiceImpl.doFouthThing())",throwing="e")
	public void afterThrowing(Throwable e){
		System.out.println("注解配置AOP异常通知："+e.getMessage());
	}
	@Around(value="execution(* *..UserServiceImpl.doFifthThing())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("注解配置AOP环绕通知前：");
		Object result=pjp.proceed();
		System.out.println("注解配置AOP环绕通知后：");
		return result;
	}

}
