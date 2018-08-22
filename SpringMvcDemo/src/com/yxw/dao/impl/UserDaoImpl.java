package com.yxw.dao.impl;

import com.yxw.dao.MyMapper;
import com.yxw.dao.MyOrderMapper;
import com.yxw.dao.UserDao;
import com.yxw.modal.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/2.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public int findUser(String username,String password) {
        String sql="select * from user where username=? and password=?";
        List<User> list = jdbcTemplate.query(sql, new MyMapper(), username, password);
        return list.size();
    }

    /**
     * 根据id 删除用户
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE from user WHERE id=?",id);
    }

    @Override
    public List<User> findAllUsers() {
        String sql="select * from user";
        List<User> userList = jdbcTemplate.query(sql, new MyMapper());
        return userList;
    }

    @Override
    public List<User> findOrdersByUid(int uid) {
       String sql="select u.id,u.username,o.id,o.number,o.createtime from user u left join orders o on u.id=o.user_id where u.id=?";
    //    String sql="select * from user u left join orders o on u.id=o.user_id where u.id=?";
        List<User> userList = jdbcTemplate.query(sql, new MyOrderMapper(), uid);
        return userList;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set username=?,password=?,birthday=?,sex=?,address=? where id=?";
        jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getBirthday(),user.getSex(),user.getAddress(),user.getUid());
    }

    @Override
    public User findUserById(int uid) {
        String sql="select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new MyMapper(), uid);
        return user;
    }
}
