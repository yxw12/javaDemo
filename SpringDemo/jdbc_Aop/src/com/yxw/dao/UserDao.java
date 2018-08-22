package com.yxw.dao;

import com.yxw.pojo.User;
import com.yxw.pojo.User_mysql;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
public interface UserDao {
    Object[] findAll() throws SQLException;
    User_mysql findById(Integer id);
}
