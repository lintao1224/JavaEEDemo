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

public class Test4 {
	@Test
	public void test01() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_jdbc.xml");
		UserService userService = (UserService) context.getBean("userService");
		TUser user = new TUser();
		user.setUpass("111");
		user.setUname("С��");
		userService.addUser(user);
		userService.updateUser(user);

	}
	@Test
	public void test02() {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_jdbc.xml");
	    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	    String sql = "select count(*) from t_user";
	    Long row = jdbcTemplate.queryForObject(sql, Long.class);
	    System.out.println("��ѯ�����ļ�¼��Ϊ��" + row);
	}
	@Test
	public void test3() {
	    // ���jdbcTemplate����
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_jdbc.xml");
	    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	    String sql = "select uname, upass from t_user where uname = ?";
	    // �趨����
	    Object[] object = {"С��"};
	    
	    // ���в�ѯ
	    TUser user = jdbcTemplate.queryForObject(sql, object,  new UserMapper());
	    System.out.println(user);
	}
	@Test
	public void test4() {
	    // ���jdbcTemplate����
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_jdbc.xml");
	    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

	    // sql���
	    String sql = "select * from t_user";
	    List<TUser> users = jdbcTemplate.query(sql, new UserMapper());

	    for(TUser u: users) {
	        System.out.println(u);
	    }
	}

}
