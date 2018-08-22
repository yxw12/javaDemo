package com.yxw.service.impl;

import com.yxw.dao.UserDao;
import com.yxw.modal.User;
import com.yxw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public int findUser(String username,String password) {
        return userDao.findUser(username,password);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public List<User> findOrdersByUid(int uid) {
        return userDao.findOrdersByUid(uid);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUserById(int uid) {
        return userDao.findUserById(uid);
    }
}
