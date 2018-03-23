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
		System.out.println("ע������AOPǰ��֪ͨ");
	}
	@After("execution(* *..UserServiceImpl.doOtherThing())")
	public void after(){
		System.out.println("ע������AOP����֪ͨ");
	}
	@AfterReturning(value="execution(* *..UserServiceImpl.doThirdThing())",returning="result")
	public void afterReturning(Object result){
		System.out.println("���÷���ֵ��ǿ��"+result);
	}
	@AfterThrowing(value="execution(* *..UserServiceImpl.doFouthThing())",throwing="e")
	public void afterThrowing(Throwable e){
		System.out.println("ע������AOP�쳣֪ͨ��"+e.getMessage());
	}
	@Around(value="execution(* *..UserServiceImpl.doFifthThing())")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("ע������AOP����֪ͨǰ��");
		Object result=pjp.proceed();
		System.out.println("ע������AOP����֪ͨ��");
		return result;
	}

}
