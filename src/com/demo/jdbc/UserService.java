package com.demo.jdbc;

import com.demo.bean.TUser;

public class UserService {

    // 加入userDao作为成员变变量
    private UserDao userDao;

    // 注意这里要增加get和set方法
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(TUser user) {
        userDao.addUser(user);
    }
    public void deleteUser(String uname) {
        userDao.deleteUser(uname);
    }
    public void updateUser(TUser user) {
        userDao.updateUser(user);
    }
}