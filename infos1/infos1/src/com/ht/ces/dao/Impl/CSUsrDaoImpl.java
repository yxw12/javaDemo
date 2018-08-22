package com.ht.ces.dao.Impl;

import com.ht.ces.DButils;
import com.ht.ces.dao.CSUsrDao;
import com.ht.ces.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSUsrDaoImpl implements CSUsrDao{
    @Override
    public void saveUser(User user) {
        String sql="insert into user values (null,?,?,?,?,?,?)";
        PreparedStatement pstmt=null;
        try {
            Connection conn = DButils.getConn();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getGender());
            pstmt.setString(4,user.getAddress());
            pstmt.setDate(5,new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setString(6,user.getPic());
            System.out.println(user.getPic());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }
    }

    public void updateUser(User user) {
        String sql="UPDATE USER  SET USERNAME=?,PASSWORD=?,GENDER=?,ADDRESS=?,BIRTHDAY=?,PIC=? WHERE USER_ID=?";
        PreparedStatement pstmt=null;
        try {
            pstmt= DButils.getPstmt(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getGender());
            pstmt.setString(4,user.getAddress());
            pstmt.setDate(5,new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setString(6,user.getPic());
            pstmt.setInt(7,user.getUserId());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        Connection conn =DButils.getConn();
        String sql="select * from user where user_id=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        User u=new User();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs=pstmt.executeQuery();
            while (rs.next()){
                String username=rs.getString("username");
                String password=rs.getString("password");
                Integer gender=rs.getInt("gender");
                String address=rs.getString("address");
                java.util.Date birthday=rs.getDate("birthday");
                String pic=rs.getString("pic");

                u.setUserId(userId);
                u.setAddress(address);
                u.setBirthday(birthday);
                u.setGender(gender);
                u.setPassword(password);
                u.setName(username);
                u.setPic(pic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return u;
    }

    @Override
    public List<User> listUser() {
        String sql="select * from user";
        Connection conn=DButils.getConn();
        List<User> list=new ArrayList<User>();
        PreparedStatement pstmt= null;
        ResultSet rs=null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs= pstmt.executeQuery();
            while (rs.next()){
                Integer userId=rs.getInt("user_id");
                String username=rs.getString("username");
                String password=rs.getString("password");
                Integer gender=rs.getInt("gender");
                String address=rs.getString("address");
                Date birthday=rs.getDate("birthday");
                String pic=rs.getString("pic");

                User u=new User();
                u.setAddress(address);
                u.setBirthday(birthday);
                u.setGender(gender);
                u.setName(username);
                u.setPassword(password);
                u.setUserId(userId);
                u.setPic(pic);
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return list;
    }

    public void deleteUser(Integer userId) {
        String sql="DELETE FROM user WHERE USER_ID=?";
        PreparedStatement pstmt = null;
        try {
            pstmt=DButils.getPstmt(sql);
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }
    }

    @Override
    public User getUserByNameAndPass(String username, String password) {
        String sql="select * from user where USERNAME=? and PASSWORD=?";
        PreparedStatement pstmt=null;
        User u=null;
        ResultSet rs=null;
        try {
            pstmt = DButils.getPstmt(sql);
            System.out.println(pstmt);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
           rs= pstmt.executeQuery();

            if (rs.next()){
                Integer userId=rs.getInt("user_id");
                Integer gender=rs.getInt("gender");
                String address=rs.getString("address");
                Date birthday=rs.getDate("birthday");


                u =new User();
                u.setAddress(address);
                u.setBirthday(birthday);
                u.setGender(gender);
                u.setName(username);
                u.setPassword(password);
                u.setUserId(userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return u;
    }
}
