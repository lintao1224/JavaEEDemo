package com.demo.jdbc.transaction;
public class AccountService {
        
    private AccountDAO userDao;

    public AccountDAO getUserDao() {
        return userDao;
    }
    public void setUserDao(AccountDAO userDao) {
        this.userDao = userDao;
    }

    //    转账的实际操作
    public void changeAccount(){
        userDao.money_less();
//        String s1 = null; //模拟异常。  事务回滚，数据不改变
//        s1.charAt(0);
        userDao.money_more();
    }
        
}