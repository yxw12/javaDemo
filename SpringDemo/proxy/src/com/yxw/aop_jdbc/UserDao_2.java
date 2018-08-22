package com.yxw.aop_jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Yan on 2018/7/30.
 */
public class UserDao_2 {
    //接受容器注入的 DataSource 对象
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //原始的jdbc 代码
    public void saveUser() {
        PreparedStatement pstmt=null;
        Connection conn =null;
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO user_login VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 10);
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
