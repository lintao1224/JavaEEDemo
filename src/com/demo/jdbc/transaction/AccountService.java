package com.demo.jdbc.transaction;
public class AccountService {
        
    private AccountDAO userDao;

    public AccountDAO getUserDao() {
        return userDao;
    }
    public void setUserDao(AccountDAO userDao) {
        this.userDao = userDao;
    }

    //    ת�˵�ʵ�ʲ���
    public void changeAccount(){
        userDao.money_less();
//        String s1 = null; //ģ���쳣��  ����ع������ݲ��ı�
//        s1.charAt(0);
        userDao.money_more();
    }
        
}