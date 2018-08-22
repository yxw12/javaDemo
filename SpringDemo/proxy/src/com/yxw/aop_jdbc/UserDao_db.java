package com.yxw.aop_jdbc;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by Yan on 2018/7/30.
 */
@Component("UserDao_db")
public class UserDao_db implements IUserDao{
    // 接收容器注入的JdbcTemplate对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    //添加数据
    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO user_login VALUES (?,?,?)",user.getUid(),user.getUsername(),user.getPassword());
    }

    //更新数据
    @Override
    public void update(User user) {
         jdbcTemplate.update("UPDATE user_login set username=? where userid=?",user.getUsername(),user.getUid());
    }

    //删除数据
    @Override
    public void delete(Serializable id) {
          jdbcTemplate.update("DELETE from user_login where userid=?",id);
    }

    //根据id 查询单个数据
    @Override
    public User findById(Serializable id) {
        // queryForList 把每一行都封装为map对象，再添加到list中
//		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_dept");

        // 传入类型参数，表示查询的列的类型；  这里只能查询一列
//		List<String> list = jdbcTemplate.queryForList("select deptName from t_dept", String.class);

        List<User> list = jdbcTemplate.query("select * from user_login where userid=?", new MyRowMapper(),id);

        return (list!=null&&list.size()>0)?list.get(0):null;
    }

    //查询所有
    @Override
    public List<User> getAll() {
        List<User> list = jdbcTemplate.query("select * from user_login", new MyRowMapper());
        return list;
    }


    // 封装Springjdbc查询的结果集
    class MyRowMapper implements RowMapper<User>{
        // 如何解析一行
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUid(rs.getInt("userid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }

    }


}
