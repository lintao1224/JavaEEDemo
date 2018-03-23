package com.demo.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.mybatis.beans.OrderCustom;
import com.demo.mybatis.beans.Orders;
import com.demo.mybatis.beans.User;
import com.demo.mybatis.mapper.UserMapper;
import com.demo.mybatis.mapper.mapper;
import com.demo.mybatis.tools.DBTools;
/**
 * 业务类
 *
 */
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class); 
    public static void main(String[] args) {
    	
    	//findOrdersUserResultMap();
    	//一对多查询
    	//findOrdersAndOrderDetailResultMap();
    	//多对多查询
    	//findUserAndItemsResultMap();
    	//findUserById();
    	//延时加载
    	//findOrdersUserLazyLoading();
    	//testCache1();
    	//testCache2();
    }
    public   void findOrdersUserResultMap(){
        SqlSession session=DBTools.getSession();
        mapper mapper=session.getMapper(mapper.class);
        try {
			List<Orders>  list=mapper.findOrdersUserResultMap();
        	for (Orders orders : list) {
				System.out.println(orders);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 一对多查询
     */
    public void findOrdersAndOrderDetailResultMap(){
        SqlSession session=DBTools.getSession();
        mapper mapper=session.getMapper(mapper.class);
        try {
        	List<Orders>  list=mapper.findOrdersAndOrderDetailResultMap();
        	for (Orders orders : list) {
				System.out.println(orders);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 多对多查询
     */
    public void findUserAndItemsResultMap(){
        SqlSession session=DBTools.getSession();
        mapper mapper=session.getMapper(mapper.class);
        try {
        	List<User>  list=mapper.findUserAndItemsResultMap();
        	for (User user : list) {
				System.out.println("用户名"+user.getUsername());
        		List<Orders> orderlist=user.getOrdersList();
				for (Orders orders : orderlist) {
					System.out.println("订单号："+orders.getNumber());
				}
				System.out.println("-----------------");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void findUserById(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        	User  user=mapper.findUserById(2);
        	System.out.println(user.getUsername());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 延迟加载
     */
    private static void findOrdersUserLazyLoading(){
    	 SqlSession session=DBTools.getSession();
         mapper mapper=session.getMapper(mapper.class);
        try {
        	List<Orders> orders=mapper.findOrdersUserLazyLoading();
        	Orders ord=orders.get(0);
        	System.out.println(ord.getNumber());
        	System.out.println(ord.getUser().getUsername());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 查询一级缓存
     */
    public void queryCache1() {
    	SqlSession session=DBTools.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		//下边查询使用一个SqlSession
		try {
			//第一次发起请求，查询id为1的用户
			User user1 = userMapper.findUserById(1);
			System.out.println(user1);
			
//		如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
			//更新user1的信息
			user1.setUsername("Test33");
			userMapper.updateUser(user1);
			//执行commit操作去清空缓存
			session.commit();
			//第二次发起请求，查询id为1的用户
			User user2 = userMapper.findUserById(1);
			System.out.println(user2);
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    /**
     * 查询二级缓存
     */
    public void queryCache2(){
    	try {
			SqlSession sqlSession1=DBTools.getSession();
			SqlSession sqlSession2=DBTools.getSession();
			SqlSession sqlSession3=DBTools.getSession();
			// 创建代理对象
			UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
			// 第一次发起请求，查询id为1的用户
			User user1 = userMapper1.findUserById(1);
			System.out.println(user1);
			//这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
			sqlSession1.close();
			
			//使用sqlSession3执行commit()操作
			UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
			User user  = userMapper3.findUserById(1);
			user.setUsername("Tomcat");
			userMapper3.updateUser(user);
			//执行提交，清空UserMapper下边的二级缓存
			sqlSession3.commit();
			sqlSession3.close();

			UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
			// 第二次发起请求，查询id为1的用户
			User user2 = userMapper2.findUserById(1);
			System.out.println(user2);

			sqlSession2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
