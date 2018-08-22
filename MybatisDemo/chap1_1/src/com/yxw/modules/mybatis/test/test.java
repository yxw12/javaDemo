package com.yxw.modules.mybatis.test;

import com.yxw.modules.mybatis.dao.UserDao;
import com.yxw.modules.mybatis.dao.impl.UserDaoImpl;
import com.yxw.modules.mybatis.pojo.Order;
import com.yxw.modules.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Yan on 2018/8/1.
 */
public class test {

    private SqlSessionFactory sqlSessionFactory;

   @Before
    public void testBefore() throws IOException {
        // 2. 加载SqlMapConfig.xml配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 1. 创建SqlSessionFactoryBuilder对象
        // 3. 创建SqlSessionFactory对象
       sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 根据id 查询用户
     * @throws IOException
     */
    @Test
    public void findById() throws IOException {

        // 4. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.创建dao层
        UserDao userDao=new UserDaoImpl(this.sqlSessionFactory);
        //6.执行查询
        User user = userDao.findById(28);
        System.out.println(user.toString());
        // 7. 释放资源
        session.close();
    }

    /**
     * 根据姓名模糊查询
     * @throws IOException
     */
    @Test
    public void findUserList() throws IOException {

        // 4. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.创建dao层
        UserDao userDao=new UserDaoImpl(this.sqlSessionFactory);
        //6.执行查询
 //       List<User> userlist = userDao.finadByName("三");
        List<User> userlist = userDao.findUserList();
        for (User user:userlist) {
            System.out.println(user.toString());
        }
        // 7. 释放资源
        session.close();
    }

    /**
     * 根据id删除用户
     * @throws IOException
     */
    @Test
    public void deleteUser() throws IOException {

        // 4. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //5.创建dao层
        UserDao userDao=new UserDaoImpl(this.sqlSessionFactory);
        //6.执行查询
        int i = userDao.deleteUser(28);
        System.out.println(i);

        // 7. 释放资源
        session.close();
    }

    /**
     * 插入用户数据
     * @throws IOException
     */
    @Test
    public void insertUser() throws IOException {

        // 4. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.创建dao层
        UserDao userDao=new UserDaoImpl(this.sqlSessionFactory);
        //6.执行查询
        User user=new User();
      //  user.setId(28);
        user.setUsername("李四");
        user.setBirthday(new Date());
        user.setAddress("重庆");
        userDao.insertUser(user);

        //将用户的 id 返回存入 orders 表中
        Order order=new Order();
        order.setUser_id(user.getId());
        order.setCreatetime(new Date());
        order.setNumber("9999");
        order.setNote("I buy an phone");

        userDao.insertOrder(order);

        List<Order> orderList = userDao.findOrderList();
        for (Order order1:orderList) {
            System.out.println(order1.toString());
        }

        // 7. 释放资源
        session.close();
    }

    /**
     * 更新用户数据
     * @throws IOException
     */
    @Test
    public void updateUser() throws IOException {

        // 4. 创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //5.创建dao层
        UserDao userDao=new UserDaoImpl(this.sqlSessionFactory);
        //6.执行查询
        User user=new User();
        user.setId(22);
        user.setUsername("陈晓明");
        user.setBirthday(new Date());
        user.setAddress("西藏山南");
        userDao.updateUser(user);

        session.commit();

        // 7. 释放资源
        session.close();
    }
}
