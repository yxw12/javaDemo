package com.yxw.shop.service.Impl;

import com.yxw.shop.dao.Impl.UserDaoImpl;
import com.yxw.shop.dao.UserDao;
import com.yxw.shop.modal.User;
import com.yxw.shop.service.UserService;

import java.sql.SQLException;

/**
 * Created by Yan on 2018/7/17.
 */
public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
    @Override
    public int regist(User user) {
        return userDao.regist(user);
    }

    @Override
    public void active(String activeCode) {
        userDao.active(activeCode);
    }

    @Override
    public Long checkUsername(String username) {
        return userDao.checkUsername(username);
    }

    @Override
    public User findUserByNamePass(String username, String password) {
        User user=null;
        try {
            user=userDao.findUserByNamePass(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
