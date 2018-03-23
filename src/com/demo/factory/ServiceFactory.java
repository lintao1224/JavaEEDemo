package com.demo.factory;

import com.demo.service.IUserService;
import com.demo.service.UserServiceImpl;

public class ServiceFactory {
	public   IUserService getUserService(){
		return new UserServiceImpl();
	}
	
}
