package com.yxw.service;

import com.yxw.pojo.User;
import com.yxw.pojo.User_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
public interface UserService {
    public Object[] findAll();
    User_mysql findById(Integer id);
   // void closeDB(ResultSet rs, PreparedStatement ps, Connection conn);
}
