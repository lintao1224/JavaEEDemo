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
 * ҵ����
 *
 */
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class); 
    public static void main(String[] args) {
    	
    	//findOrdersUserResultMap();
    	//һ�Զ��ѯ
    	//findOrdersAndOrderDetailResultMap();
    	//��Զ��ѯ
    	//findUserAndItemsResultMap();
    	//findUserById();
    	//��ʱ����
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
     * һ�Զ��ѯ
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
     * ��Զ��ѯ
     */
    public void findUserAndItemsResultMap(){
        SqlSession session=DBTools.getSession();
        mapper mapper=session.getMapper(mapper.class);
        try {
        	List<User>  list=mapper.findUserAndItemsResultMap();
        	for (User user : list) {
				System.out.println("�û���"+user.getUsername());
        		List<Orders> orderlist=user.getOrdersList();
				for (Orders orders : orderlist) {
					System.out.println("�����ţ�"+orders.getNumber());
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
     * �ӳټ���
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
     * ��ѯһ������
     */
    public void queryCache1() {
    	SqlSession session=DBTools.getSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		//�±߲�ѯʹ��һ��SqlSession
		try {
			//��һ�η������󣬲�ѯidΪ1���û�
			User user1 = userMapper.findUserById(1);
			System.out.println(user1);
			
//		���sqlSessionȥִ��commit������ִ�в��롢���¡�ɾ���������SqlSession�е�һ�����棬��������Ŀ��Ϊ���û����д洢�������µ���Ϣ�����������
			//����user1����Ϣ
			user1.setUsername("Test33");
			userMapper.updateUser(user1);
			//ִ��commit����ȥ��ջ���
			session.commit();
			//�ڶ��η������󣬲�ѯidΪ1���û�
			User user2 = userMapper.findUserById(1);
			System.out.println(user2);
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    /**
     * ��ѯ��������
     */
    public void queryCache2(){
    	try {
			SqlSession sqlSession1=DBTools.getSession();
			SqlSession sqlSession2=DBTools.getSession();
			SqlSession sqlSession3=DBTools.getSession();
			// �����������
			UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
			// ��һ�η������󣬲�ѯidΪ1���û�
			User user1 = userMapper1.findUserById(1);
			System.out.println(user1);
			//����ִ�йرղ�������sqlsession�е�����д��������������
			sqlSession1.close();
			
			//ʹ��sqlSession3ִ��commit()����
			UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
			User user  = userMapper3.findUserById(1);
			user.setUsername("Tomcat");
			userMapper3.updateUser(user);
			//ִ���ύ�����UserMapper�±ߵĶ�������
			sqlSession3.commit();
			sqlSession3.close();

			UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
			// �ڶ��η������󣬲�ѯidΪ1���û�
			User user2 = userMapper2.findUserById(1);
			System.out.println(user2);

			sqlSession2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
