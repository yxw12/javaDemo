package com.yxw.dao;

import com.yxw.modal.User;

import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
public interface UserDao {
    int findUser(String username,String password);
    void deleteUser(int id);

    List<User> findAllUsers();

    List<User> findOrdersByUid(int uid);

    void updateUser(User user);

    User findUserById(int uid);
}

