package com.demo.mybatis.mapper;

import java.util.List;

import com.demo.mybatis.beans.OrderCustom;
import com.demo.mybatis.beans.Orders;
import com.demo.mybatis.beans.User;

public interface mapper {
	public List<OrderCustom> findOrderUser() throws Exception;	
	public List<Orders> findOrdersUserResultMap()  throws Exception;	
	public List<Orders> findOrdersAndOrderDetailResultMap()  throws Exception;
	public List<User> findUserAndItemsResultMap()  throws Exception;
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
