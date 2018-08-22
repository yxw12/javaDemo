package com.yxw.aop_jdbc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/7/29.
 */
@Component("App")
public class App {
    private static UserDao_db userDao_db;
    @Resource
    public void setUserDao_db(UserDao_db userDao_db) {
        this.userDao_db = userDao_db;
    }

    @Test
    public void myTest() throws Exception {
//        userDao_db =ac.getBean("userDao_db",UserDao_db.class);
  //      System.out.println(userDao_db);

       /* User user = (User) userDao_db.findById(1);
        System.out.println(user.getUsername()+"..."+user.getPassword());*/

        /*List<User> userList = userDao_db.getAll();
        for (User user : userList) {
            System.out.println(user.getUsername()+"......."+user.getPassword());
        }*/
        new ClassPathXmlApplicationContext("com/yxw/aop_jdbc/spring-config.xml");
        userDao_db.delete(13);

       /* User user=new User();
        user.setUid(13);
        user.setUsername("zhangsan");
        user.setPassword("lisi");
        userDao_db.save(user);*/

    }


}
