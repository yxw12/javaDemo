package com.yxw.dao;

import com.yxw.modal.Order;
import com.yxw.modal.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yan on 2018/8/3.
 */
public class MyOrderMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        Order order=new Order();
        user.setUid(rs.getInt(1));
        user.setUsername(rs.getString(2));
        order.setOid(rs.getInt(3));
        order.setNumber(rs.getString(4));
        order.setCreatetime(rs.getDate(5));
        user.setOrders(order);
        return user;
    }
}