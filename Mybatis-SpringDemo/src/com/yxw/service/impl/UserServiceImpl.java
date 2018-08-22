package com.yxw.service.impl;

import com.yxw.dao.UserDao;
import com.yxw.modal.User;
import com.yxw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/8/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }
}
