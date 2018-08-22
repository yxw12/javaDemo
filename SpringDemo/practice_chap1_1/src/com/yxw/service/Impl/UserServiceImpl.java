package com.yxw.service.Impl;

import com.yxw.dao.UserDao;
import com.yxw.modal.User;
import com.yxw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/7/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public List<User> findUserList() {

        return userDao.findUserList();
    }
}
