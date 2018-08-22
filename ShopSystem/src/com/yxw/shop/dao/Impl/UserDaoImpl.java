package com.yxw.shop.dao.Impl;

import com.yxw.shop.dao.UserDao;
import com.yxw.shop.modal.User;
import com.yxw.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Yan on 2018/7/17.
 */
public class UserDaoImpl implements UserDao{
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public int regist(User user) {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        int update = 0;
        try {
            update = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),
                    user.getBirthday(),user.getSex(),user.getState(),user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    /**
     * 根据激活码激活用户
     * @param activeCode
     */
    @Override
    public void active(String activeCode) {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="update user set state=? where code=?";
        try {
            runner.update(sql,1,activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
    @Override
    public Long checkUsername(String username) {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from user where username=?";
        Long number=null;
        try {
            number = (Long) runner.query(sql,new ScalarHandler(),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public User findUserByNamePass(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user where username=? and password=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        return user;
    }
}
