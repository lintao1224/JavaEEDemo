package com.demo.jdbc;

import com.demo.bean.TUser;

public class UserService {

    // ����userDao��Ϊ��Ա�����
    private UserDao userDao;

    // ע������Ҫ����get��set����
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