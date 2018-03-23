package com.demo.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.aop2.IUserService;
import com.demo.bean.TUser;
import com.demo.jdbc.UserMapper;
import com.demo.jdbc.UserService;
import com.demo.jdbc.transaction.AccountService;
/**
 * 事务处理
 * @author Administrator
 *
 */
public class Test5 {
	@Test
	public void test01() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc2.xml");
		AccountService service = (AccountService)context.getBean("service");
	    service.changeAccount();

	}

}
