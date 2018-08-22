package com.yxw.modules.mybatis.dao;

import com.yxw.modules.mybatis.pojo.Order;
import com.yxw.modules.mybatis.pojo.User;

import java.util.List;

/**
 * Created by Yan on 2018/7/31.
 */
public interface UserDao {
    User findById(Integer id);
    List<User> finadByName(String name);
    List<User> findUserList();
    int updateUser(User user);
    int deleteUser(Integer id);
    int insertUser(User user);

    List<Order> findOrderList();
    int insertOrder(Order order);
}