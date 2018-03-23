package com.demo.aop;

public class UserServiceImpl implements IUserService{
	@Override
	public void doSomeThing(){
		//ValidateUtils.doValidate();
		System.out.println("call doSomeThing method...");
		//LogUtils.doLog();
	}	
	@Override
	public void doOtherThing() {
		//ValidateUtils.doValidate();
		System.out.println("call doOtherThing method...");
		//LogUtils.doLog();
	}
	@Override
	public String doThirdThing() {
		//ValidateUtils.doValidate();
		System.out.println("call doThirdThing method...");
		//LogUtils.doLog();
		return "OK";
	}
	@Override
	public void doFouthThing() throws Exception {
		//ValidateUtils.doValidate();
		System.out.println("call doFouthThing method...");
		throw new Exception("throw doFouthThing Exception");
	}
	@Override
	public void doFifthThing() {
		//ValidateUtils.doValidate();
		System.out.println("call doFifthThing method...");
	}

}
