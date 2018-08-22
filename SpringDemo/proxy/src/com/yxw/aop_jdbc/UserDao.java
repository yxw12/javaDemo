package com.yxw.aop_jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Yan on 2018/7/30.
 */
public class UserDao{
    //原始的jdbc 代码

    public void findByUid() {
        PreparedStatement pstmt=null;
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "123");
            String sql = "INSERT INTO user_login VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 12);
            pstmt.setString(2, "fanwenxin");
            pstmt.setString(3, "yanxuewen");
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
