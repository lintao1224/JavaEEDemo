package com.demo.mybatis.test;

import org.junit.Test;

import com.demo.mybatis.service.UserService;

public class TestMybatis {
	@Test  
	public  void  testInsert(){
		new UserService().insertUser();
	}
	@Test  
	public  void  testdelete(){
		new UserService().deleteUser(1);
	}
	@Test  
	public  void  testSelectUserById(){
		new UserService().selectUserById(1);
	}
	@Test  
	public  void  testSelectAllUser(){
		new UserService().selectAllUser();
	}
}
