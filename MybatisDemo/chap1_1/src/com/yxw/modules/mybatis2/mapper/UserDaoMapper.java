package com.yxw.modules.mybatis2.mapper;

import com.yxw.modules.mybatis2.pojo.Order;
import com.yxw.modules.mybatis2.pojo.QueryVo;
import com.yxw.modules.mybatis2.pojo.User;

import java.util.List;


/**
 * Created by Yan on 2018/8/2.
 */
public interface UserDaoMapper {

    List<User> findByName(QueryVo vo);

    List<User> findUserByIdName(User user);

    List<User> findIds(QueryVo vo);

    int findCount();

    List<Order> findAllOrders();



}
