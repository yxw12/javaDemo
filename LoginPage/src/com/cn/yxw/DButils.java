package com.cn.yxw;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Yan on 2018/7/9.
 */
public class DButils {
    //获得Connection连接
    public static Connection getConn() {
        Properties prop=new Properties();
        Connection conn=null;
        InputStream in = DButils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            prop.load(in);
            String username=prop.getProperty("username");
            String password=prop.getProperty("password");
            String driverClass=prop.getProperty("driverClass");//1：首先获取数据库驱动
            String url=prop.getProperty("url");
            //注册驱动
            Class.forName(driverClass);
            conn= DriverManager.getConnection(url,username,password);//2：得到连接对象
            if (!conn.isClosed()) {
          //      System.out.println("数据库连接成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        }
        return conn;
    }

    //获得PreparedStatement
    public static PreparedStatement getPstmt(String sql){
        Connection conn=getConn();
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        return pstmt;
    }

    //增删改的关闭方法
    public static void closeUpdateRes(PreparedStatement ps){
        if (ps!=null){
            try {
                Connection conn = ps.getConnection();
                ps.close();
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //查的关闭方法
    public static void closeQueryRes(ResultSet rs){
        if(rs!=null){
            try {
                Statement pstmt=rs.getStatement();
                if(pstmt!=null){
                    Connection conn=pstmt.getConnection();
                    rs.close();
                    pstmt.close();
                    if(conn!=null){
                        conn.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
