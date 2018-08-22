package com.yxw.modules.mybatis2.test;

import com.yxw.modules.mybatis2.mapper.OrderDaoMapper;
import com.yxw.modules.mybatis2.mapper.UserDaoMapper;
import com.yxw.modules.mybatis2.pojo.Order;
import com.yxw.modules.mybatis2.pojo.QueryVo;
import com.yxw.modules.mybatis2.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

        @Test
        public void selectQueryVo() throws IOException {

            // 4. 创建SqlSession对象
            SqlSession session = sqlSessionFactory.openSession();
            UserDaoMapper mapper = session.getMapper(UserDaoMapper.class);
            QueryVo vo=new QueryVo();
            User user=new User();
            user.setUsername("张");
            vo.setUser(user);
            List<User> users = mapper.findByName(vo);

            for (User user1:users) {
                System.out.println(user1.toString());
            }
            // 7. 释放资源
            session.close();
        }

    @Test
    public void selectCount() throws IOException {

        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession session = sqlSessionFactory.openSession();

        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        UserDaoMapper mapper = session.getMapper(UserDaoMapper.class);

        // 使用mapper执行查询用户数据条数
        int count = mapper.findCount();
        System.out.println(count);
        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

    @Test
    public void selectOrders() throws IOException {

        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession session = sqlSessionFactory.openSession();

        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        UserDaoMapper mapper = session.getMapper(UserDaoMapper.class);

        // 使用mapper执行查询订单表
        List<Order> orderList = mapper.findAllOrders();
        for (Order order:orderList) {
            System.out.println(order.getId()+"..."+order.getUserId()+"..."+order.getNumber()+"..."+order.getCreatetime()+
            "..."+order.getUser().getUsername()+"..."+order.getUser().getAddress());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

    @Test
    public void selectUserByIdName() throws IOException {

        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession session = sqlSessionFactory.openSession();

        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        UserDaoMapper mapper = session.getMapper(UserDaoMapper.class);

        User user=new User();
        user.setSex("1");
        user.setUsername("小");
  //      user.setAddress("河南");
        // 使用mapper执行查询订单表
        List<User> userList = mapper.findUserByIdName(user);
        for (User user1:userList) {
            System.out.println(user1.toString());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

    @Test
    public void selectIds() throws IOException {

        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession session = sqlSessionFactory.openSession();

        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        UserDaoMapper mapper = session.getMapper(UserDaoMapper.class);

        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(16);
        list.add(22);
        vo.setIds(list);
        //      user.setAddress("河南");
        // 使用mapper执行查询订单表
        List<User> userList = mapper.findIds(vo);
        for (User user1:userList) {
            System.out.println(user1.toString());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

    @Test
    public void selectUsers() throws IOException {

        // mybatis和spring整合，整合之后，交给spring管理
        SqlSession session = sqlSessionFactory.openSession();

        // 创建Mapper接口的动态代理对象，整合之后，交给spring管理
        OrderDaoMapper mapper = session.getMapper(OrderDaoMapper.class);


        List<User> userList = mapper.findAllUser();
        for (User user1:userList) {
            System.out.println(user1.toString());
        }

        // mybatis和spring整合，整合之后，交给spring管理
        session.close();
    }

}
