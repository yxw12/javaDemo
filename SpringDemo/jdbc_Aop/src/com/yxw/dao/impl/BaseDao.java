package com.yxw.dao.impl;


import java.sql.*;


/**
 * Created by Yan on 2018/8/1.
 */
public class BaseDao {

    private String driverClass;
    private String url;
    private String user;
    private String password;

/*    public BaseDao(String driverClass, String url, String user, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }*/

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConn(){
        Connection connection=null;
        try {

            Class.forName(driverClass);
        //    System.out.println(driverClass);
         //   Class.forName("com.mysql.jdbc.Driver");
        //    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "123");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return connection;
    }

   /* public void closeDB(ResultSet rs, PreparedStatement ps, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }*/
}
