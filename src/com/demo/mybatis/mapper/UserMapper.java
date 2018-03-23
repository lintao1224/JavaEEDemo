package com.demo.mybatis.mapper;

import java.util.List;

import com.demo.mybatis.beans.OrderCustom;
import com.demo.mybatis.beans.Orders;
import com.demo.mybatis.beans.User;

public interface UserMapper {
	public User findUserById(int value)  throws Exception;

	public void updateUser(User user1);
}
