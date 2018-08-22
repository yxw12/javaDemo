package com.yxw.dao;

import com.yxw.modal.User;

import java.util.List;

/**
 * Created by Yan on 2018/7/27.
 */
public interface UserDao {
    public List<User> findUserList();

}
