package com.yxw.modules.mybatis2.mapper;

import com.yxw.modules.mybatis2.pojo.User;

import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
public interface OrderDaoMapper {
    List<User> findAllUser();
}
