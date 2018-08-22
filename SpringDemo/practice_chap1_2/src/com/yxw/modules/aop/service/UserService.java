package com.yxw.modules.aop.service;

import com.yxw.modules.aop.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/31.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public void save(String string){
        userDao.save(string);
    }

    public void query() {
        userDao.query();
    }
}
