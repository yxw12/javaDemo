package com.yxw.aop_txJdbc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Yan on 2018/7/30.
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
   //     int i=1/0;
    }

    public void delete(Serializable id){
        userDao.delete(id);
    }

    public void update(User user){
        userDao.update(user);
    }
}
