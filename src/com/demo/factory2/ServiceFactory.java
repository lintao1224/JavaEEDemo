package com.demo.factory2;

import com.demo.service.IUserService;
import com.demo.service.UserServiceImpl;

public class ServiceFactory {
	public  static IUserService getUserService(){
		return new UserServiceImpl();
	}
	
}
