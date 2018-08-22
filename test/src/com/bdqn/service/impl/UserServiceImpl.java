package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    public int addUser(String id, String username, String upassword) {
        int result=userDao.registerUser(id,username,upassword);
        //加入日日志
        int a=10/0;
        return result;
    }
}
