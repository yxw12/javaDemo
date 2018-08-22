package com.yxw.shop.dao;

import com.yxw.shop.modal.User;

import java.sql.SQLException;

/**
 * Created by Yan on 2018/7/17.
 */
public interface UserDao {
    public int regist(User user);//注册用户

    public void active(String activeCode);//激活用户

    public Long checkUsername(String username);//校验用户名是否存在

    public  User findUserByNamePass(String username, String password) throws SQLException;//校验用户是否存在
}
