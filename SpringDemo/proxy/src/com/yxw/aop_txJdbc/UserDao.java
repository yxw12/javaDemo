package com.yxw.aop_txJdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by Yan on 2018/7/30.
 */
@Repository
public class UserDao {
    @Resource
    JdbcTemplate jdbcTemplate=new JdbcTemplate();

    public void save(User user){
        jdbcTemplate.update("INSERT into user_login VALUES (?,?,?)",user.getUid(),user.getUsername(),user.getPassword());
    }

    public void delete(Serializable id){
        jdbcTemplate.update("DELETE from user_login where userid=?",id);
    }

    public void update(User user){
        jdbcTemplate.update("UPDATE user_login set username=? where userid=?",user.getUsername(),user.getUid());
    }
}
