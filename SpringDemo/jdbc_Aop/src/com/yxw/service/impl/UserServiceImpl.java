package com.yxw.service.impl;

import com.yxw.dao.UserDao;
import com.yxw.dao.impl.UserDaoImpl;
import com.yxw.pojo.User;
import com.yxw.pojo.User_mysql;
import com.yxw.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    @Override
    public Object[] findAll(){
     //   List<User> list=null;
        Object[] objects=null;
        try {
            objects = userDao.findAll();
           /* System.out.println((Connection) objects[2]);
            System.out.println((PreparedStatement) objects[1]);
            closeDB((ResultSet) objects[0],(PreparedStatement) objects[1],(Connection) objects[2]);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objects;
    }

    @Override
    public User_mysql findById(Integer id) {

        return userDao.findById(id);
    }

 /*   @Override
    public void closeDB(ResultSet rs, PreparedStatement ps, Connection conn) {

        System.out.println("跳转事务啦");
    }*/
}
