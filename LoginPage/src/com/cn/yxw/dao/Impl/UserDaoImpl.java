package com.cn.yxw.dao.Impl;

import com.cn.yxw.DButils;
import com.cn.yxw.dao.UserDao;
import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.Product;
import com.cn.yxw.model.RegisterUser;
import com.cn.yxw.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.Date;
import java.util.List;

/**
 * Created by Yan on 2018/7/9.
 */
public class UserDaoImpl implements UserDao{
    /**
     * 增加用户数据
     * @param user
     */
    @Override
    public void saveUser(User user) {
        String sql="INSERT INTO user VALUES (null,?,?,?,?,?)";//3:准备好sql  ？占位符
        PreparedStatement pstmt=null; //PreparedStatement防止SQL注入攻击
        try {
           if(null!=user){
               pstmt = DButils.getPstmt(sql);//4：把sql丢进执行PreparedStatement对象里
               pstmt.setString(1, user.getUsername());
               pstmt.setString(2,user.getPassword());
               pstmt.setInt(3,user.getGender());
               pstmt.setString(4,user.getAddress());
               pstmt.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
               pstmt.executeUpdate();//5.ProperStatement 接口executeQuery 执行SQL 或者获取到数据
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);//关闭连接
        }

    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void updateUser(User user) {
           String sql="UPDATE user SET user_name=?,user_password=?,user_gender=?,user_address=?,user_birthday=? WHERE user_id=?";
           PreparedStatement pstmt=null;
        try{
           pstmt = DButils.getConn().prepareStatement(sql);
           pstmt.setString(1,user.getUsername());
           pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getGender());
            pstmt.setString(4,user.getAddress());
            pstmt.setDate(5,new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setInt(6,user.getUserId());
           pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }

    }

    /**
     * 根据用户id查询用户数据
     * @param userId
     * @return
     */
    @Override
    public User getUserById(Integer userId) {
        String sql="SELECT * FROM user WHERE user_id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();
        try {
            pstmt = DButils.getConn().prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs=pstmt.executeQuery();//将获取到的数据装入结果集
            while (rs.next()){
                String username = rs.getString("user_name");//结果集ResultSet从数据库中获取参数
                String password = rs.getString("user_password");
                Integer gender=rs.getInt("user_gender");
                String address=rs.getString("user_address");
                Date birthday=rs.getDate("user_birthday");

                user.setUserId(userId); //将获取到的参数丢到user对象里面
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                user.setAddress(address);
                user.setBirthday(birthday);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return user;//返回查询到的用户
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> listUser() {
        String sql="SELECT * FROM user";
        PreparedStatement pstmt = null;
        List<User> list = new ArrayList<User>();
        ResultSet rs = null;
        try {
            pstmt = DButils.getConn().prepareStatement(sql);
            rs=pstmt.executeQuery();//将获取到的数据传入结果集
            while (rs.next()){
                User user = new User();//每次查询一个新对象
                Integer userId = rs.getInt("user_id");//从数据库中取值
                String username = rs.getString("user_name");
                String password = rs.getString("user_password");
                Integer gender=rs.getInt("user_gender");
                String address=rs.getString("user_address");
                Date birthday=rs.getDate("user_birthday");

                user.setUserId(userId);//将获取到的值丢到user对象
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                user.setAddress(address);
                user.setBirthday(birthday);

                list.add(user);//将user对象装入list集合
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return list;//返回装有对象user的集合
    }

    /**
     * 根据用户ID删除用户
     * @param userId
     */
    @Override
    public void deleteUser(Integer userId) {
        String sql = "DELETE FROM user WHERE user_id=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setInt(1,userId);
            pstmt.executeUpdate();//执行SQL删除数据
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }
    }

    /**
     * 根据用户名和密码获取用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public RegisterUser getUserByNameAndPass(String username, String password) {
        String sql = "SELECT * FROM user_login WHERE username=? AND password=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RegisterUser user = new RegisterUser();
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            System.out.println(pstmt);
            rs=pstmt.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                Integer userId = rs.getInt("userid");
          //      Integer gender = rs.getInt("user_gender");
           //     String address = rs.getString("user_address");
           //     Date birthday = rs.getDate("user_birthday");

                user.setRuserId(userId);
                user.setRusername(username);
                user.setRpassword(password);
     //           user.setGender(gender);
       //         user.setAddress(address);
       //         user.setBirthday(birthday);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return user;
    }

    /**
     * 查询总记录数
     * @return
     */
    @Override
    public Integer getTotalRecord(){
        String sql="SELECT * FROM user";
        PreparedStatement pstmt=null;
        Integer totalRecord=0;
        ResultSet rs=null;
        try {
            pstmt = DButils.getPstmt(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                totalRecord++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButils.closeQueryRes(rs);
        return totalRecord;
    }

    /**
     * 分页查询所有
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<User> findAll(Integer startIndex, Integer pageSize) {
        String sql = "SELECT * FROM user LIMIT ?,? ";
        PreparedStatement pstmt = null;
        List<User> list = new ArrayList<User>();
        ResultSet rs = null;
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setInt(1, startIndex);
            pstmt.setInt(2, pageSize);
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                Integer userId = rs.getInt("user_id");
                String username=rs.getString("user_name");
                String password =rs.getString("user_password");
                Integer gender = rs.getInt("user_gender");
                String address = rs.getString("user_address");
                java.util.Date birthday=rs.getDate("user_birthday");

                user.setUserId(userId);
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                user.setAddress(address);
                user.setBirthday(birthday);
                list.add(user);//将user对象装入list集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
            return list;
    }

    /**
     * 保存注册用户
     * @param username
     * @param password
     */
    @Override
    public Integer registerUser(String username, String password){
        String sql="INSERT INTO user_login VALUES (null,?,?)";
        PreparedStatement pstmt=null;
        Integer number=null;
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            number=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeUpdateRes(pstmt);
        }
        return number;
    }

    /**
     * 条件查询商品数据
     * @param word
     * @return
     */
    @Override
    public List<Product> productFindByWord(String word){
        String sql="SELECT * FROM product WHERE 1=1 AND pname like ? ";
        PreparedStatement pstmt=null;
        List<Product> list = new ArrayList<Product>();
        ResultSet rs=null;
        try {
            pstmt=DButils.getPstmt(sql);
            pstmt.setString(1,"%"+word+"%");
            rs = pstmt.executeQuery();
            while (rs.next()){
                Integer pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String pinyin=rs.getString("pinyin");

                Product product=new Product();
                product.setPid(pid);
                product.setPname(pname);
                product.setPinyin(pinyin);

                list.add(product);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return list;
    }

    /**
     * 根据时间和姓名模糊查询
     * @param word
     * @param startTime
     * @param endTime
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<User> FuzzyfindAll(String word, Date startTime,Date endTime,Integer startIndex, Integer pageSize){
        String sql = "SELECT * FROM user WHERE 1=1 AND user_name like ? AND user_birthday BETWEEN ? AND ?  LIMIT ?,? ";
        PreparedStatement pstmt = null;
        List<User> list = new ArrayList<User>();
        ResultSet rs = null;
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setString(1,"%"+word+"%");
            pstmt.setDate(2,new java.sql.Date(startTime.getTime()));
            pstmt.setDate(3,new java.sql.Date(endTime.getTime()));
            pstmt.setInt(4, startIndex);
            pstmt.setInt(5, pageSize);
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                Integer userId = rs.getInt("user_id");
                String username=rs.getString("user_name");
                String password =rs.getString("user_password");
                Integer gender = rs.getInt("user_gender");
                String address = rs.getString("user_address");
                Date birthday=rs.getDate("user_birthday");

                user.setUserId(userId);
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                user.setAddress(address);
                user.setBirthday(birthday);
                list.add(user);
                //将user对象装入list集合

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButils.closeQueryRes(rs);
        }
        return list;
    }

    /**
     * 根据条件查询总记录数
     * @return
     */
    @Override
    public Integer QueryTotalRecord(String word, Date startTime, Date endTime){
        String sql="SELECT * FROM user WHERE 1=1 AND user_name like ? AND user_birthday BETWEEN ? AND ?";
        PreparedStatement pstmt=null;
        Integer totalRecord=0;
        ResultSet rs=null;
        try {
            pstmt = DButils.getPstmt(sql);
            pstmt.setString(1,"%"+word+"%");
            pstmt.setDate(2,new java.sql.Date(startTime.getTime()));
            pstmt.setDate(3,new java.sql.Date(endTime.getTime()));
            rs = pstmt.executeQuery();
            while(rs.next()){
                totalRecord++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButils.closeQueryRes(rs);
        return totalRecord;
    }


}
