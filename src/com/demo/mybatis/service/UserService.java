package com.demo.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.mybatis.beans.UserBean;
import com.demo.mybatis.mapper.UserMapper;
import com.demo.mybatis.tools.DBTools;
/**
 * ҵ����
 */
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class); 
    public static void main(String[] args) {
      //  insertUser();
        //deleteUser(1);
        //selectUserById(7);
        //selectAllUser();
    }
    /**
     * �����û�
     */
    public  boolean  insertUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("test01", "123456", 7000.0);
        try {
            int index=mapper.insertUser(user);
            boolean bool=index>0?true:false;
            logger.info("�����û�user����:{},����״̬:{}",new Object[]{user,bool});
             session.commit();
             return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return false;
        }finally{
            session.close();
        }
    }
    /**
     * ɾ���û�
     * @param id �û�ID
     */
    public  boolean deleteUser(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
            int index=mapper.deleteUser(id); 
            boolean bool=index>0?true:false;
            logger.info("�����û�id:{},����״̬{}",new Object[]{id,bool});
            session.commit(); 
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback(); 
            return false;
        }finally{
            session.close();
        }
    }
    
    /**
     * ����id��ѯ�û�
     * @param id
     */
    public  void selectUserById(int id){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        UserBean user= mapper.selectUserById(id);
        logger.info("�����û�Id:{},��ѯ�û���Ϣ:{}",new Object[]{id,user});
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }
    }
    
    /**
     * ��ѯ���е��û�
     */
    public  void selectAllUser(){
        SqlSession session=DBTools.getSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        try {
        List<UserBean> user=mapper.selectAllUser();
        logger.info("��ȡ���õ��û�:{}",user);
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally{
            session.close();
        }
    }
}
