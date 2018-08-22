package com.bdqn.dao.impl;

import com.bdqn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int registerUser(String id, String username, String upassword) {
        String sql="insert into userpro values(?,?,?)";
        Object[] params=new Object[]{id,username,upassword};
        return jdbcTemplate.update(sql,params);
    }
}
