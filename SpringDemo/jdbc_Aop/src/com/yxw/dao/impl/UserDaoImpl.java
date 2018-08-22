package com.yxw.dao.impl;

import com.yxw.dao.UserDao;
import com.yxw.pojo.User;
import com.yxw.pojo.User_mysql;
import com.yxw.service.UserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Resource
    private BaseDao baseDao;

    @Override
    public Object[] findAll() throws SQLException {
        Connection conn = baseDao.getConn();
        System.out.println(conn);
        conn.setAutoCommit(true);
        String sql="select * from t_user";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<User> userList=new ArrayList<User>();
        while (rs.next()){
            User user=new User();
            user.setU_id(rs.getInt(1));
            user.setU_name(rs.getString(2));
            user.setU_age(rs.getInt(3));
            user.setU_sex(rs.getString(4));
            user.getU_tell(rs.getString(5));
            user.setU_birthday(rs.getDate(6));
     //       System.out.println(user.toString());
            userList.add(user);
        }
   //     baseDao.closeDB(rs,pstmt,conn);

        Object[] objects=new Object[4];
        objects[0]=rs;
        objects[1]=pstmt;
        objects[2]=conn;
        objects[3]=userList;
        return objects;
    }

    @Override
    public User_mysql findById(Integer id) {
        Connection conn = baseDao.getConn();
        User_mysql user=new User_mysql();
        try {
  //          conn.setAutoCommit(true);
            String sql="select * from user where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                user.setUserid(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
