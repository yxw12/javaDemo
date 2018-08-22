package com.yxw.my_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("com/yxw/my_aop/spring-config.xml");

    @Test
    public void myTest(){
        UserDao userDao = (UserDao) ac.getBean("userDao");

        userDao.save();
    }

}