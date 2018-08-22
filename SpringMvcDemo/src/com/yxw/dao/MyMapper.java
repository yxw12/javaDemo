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
public class MyMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user=new User();
        user.setUid(rs.getInt(1));
        user.setUsername(rs.getString(2));
        user.setPassword(rs.getString(3));
        user.setBirthday(rs.getDate(4));
        user.setSex(rs.getString(5));
        user.setAddress(rs.getString(6));
        return user;
    }
}
