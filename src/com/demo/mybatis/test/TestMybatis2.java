package com.demo.mybatis.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.mybatis.service.UserService;

public class TestMybatis2 {

	@Test
	public void testFindOrdersUserResultMap() {
		new UserService().findOrdersUserResultMap();
	}

	@Test
	public void testFindOrdersAndOrderDetailResultMap() {
		new UserService().findOrdersAndOrderDetailResultMap();
	}

	@Test
	public void testFindUserAndItemsResultMap() {
		new UserService().findUserAndItemsResultMap();
	}

	@Test
	public void testFindUserById() {
		new UserService().findUserById();
	}

	@Test
	public void testQueryCache1() {
		new UserService().queryCache1();
	}

	@Test
	public void testQueryCache2() {
		new UserService().queryCache2();
	}

}
